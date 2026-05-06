#!/usr/bin/env bash
# Build the org.idempiere.redis.service bundle in your iDempiere source
# checkout and stage the JAR in this folder's dropins/ for the Dockerfile
# to bake into the runtime image.
#
# No v14 iDempiere docker image is published yet (your fork is on
# 14.0.0-SNAPSHOT, but only v13-release ships publicly). We work around
# this by lowering the bundle's Require-Bundle floor from 14.0.0 to 13.0.0
# at build time only — the consumed APIs (org.idempiere.distributed.* SPI)
# are stable across v12-v14, so this works at runtime. Your working tree's
# MANIFEST.MF is restored regardless of build outcome (trap on EXIT), so
# nothing leaks into commits.
#
# Bump TARGET_BASE_VERSION to 14.0.0 once a v14-release docker image ships.
#
# Usage:
#   IDEMPIERE_SRC=/path/to/idempiere-fork bash build-dropins.sh

set -euo pipefail

: "${IDEMPIERE_SRC:?IDEMPIERE_SRC must point to your iDempiere source checkout (e.g. ~/GitHub/idempiere-fork)}"

if [[ ! -d "$IDEMPIERE_SRC/org.idempiere.redis.service" ]]; then
  echo "ERROR: $IDEMPIERE_SRC does not contain org.idempiere.redis.service/" >&2
  echo "Make sure IDEMPIERE_SRC points at the iDempiere fork that has the bundle." >&2
  exit 2
fi

DOCKER_DIR="$(cd "$(dirname "$0")" && pwd)"
MANIFEST="$IDEMPIERE_SRC/org.idempiere.redis.service/META-INF/MANIFEST.MF"
TARGET_BASE_VERSION="13.0.0"

if [[ "$(uname -s)" == "Darwin" ]] && [[ -z "${JAVA_HOME:-}" ]]; then
  JAVA_HOME="$(/usr/libexec/java_home -v 17)"
  export JAVA_HOME
fi

cp "$MANIFEST" "$MANIFEST.bak"
trap 'mv "$MANIFEST.bak" "$MANIFEST" 2>/dev/null || true' EXIT

echo "Patching MANIFEST.MF Require-Bundle floor 14.0.0 -> $TARGET_BASE_VERSION (build-time only, restored on exit)"
if ! grep -qF 'org.adempiere.base;bundle-version="14.0.0"' "$MANIFEST"; then
  echo "ERROR: expected 'org.adempiere.base;bundle-version=\"14.0.0\"' not found in $MANIFEST" >&2
  echo "       Has the bundle's Require-Bundle floor changed? Update build-dropins.sh accordingly." >&2
  exit 3
fi
sed "s/org\.adempiere\.base;bundle-version=\"14\.0\.0\"/org.adempiere.base;bundle-version=\"$TARGET_BASE_VERSION\"/" \
    "$MANIFEST" > "$MANIFEST.new"
mv "$MANIFEST.new" "$MANIFEST"

echo "Building redis bundle from $IDEMPIERE_SRC"
cd "$IDEMPIERE_SRC"
mvn -pl org.idempiere.p2.targetplatform,org.idempiere.redis.service \
    clean verify -DskipTests

echo "Refreshing $DOCKER_DIR/dropins/"
mkdir -p "$DOCKER_DIR/dropins"
rm -f "$DOCKER_DIR/dropins/org.idempiere.redis.service-"*.jar
find "$IDEMPIERE_SRC/org.idempiere.redis.service/target" \
     -maxdepth 1 -name "org.idempiere.redis.service-*.jar" \
     ! -name "*-sources.jar" \
     -exec cp {} "$DOCKER_DIR/dropins/" \;

ls -lh "$DOCKER_DIR/dropins/"
echo
echo "Done. Built JAR has Require-Bundle floor $TARGET_BASE_VERSION; working tree MANIFEST.MF restored to 14.0.0."
echo "Next: cd $DOCKER_DIR && docker compose build && bash scripts/start.sh --seed"
