#!/usr/bin/env bash
# ============================================================
# stop.sh — bring down the redis-cluster harness
# ============================================================
# Usage:
#   bash scripts/stop.sh          # stop containers, keep volumes
#   bash scripts/stop.sh --wipe   # also delete pg-data, redis-data, etc.
#                                 #   next --seed boot will re-import the DB (~3 min)
# ============================================================

set -euo pipefail

cd "$(dirname "$0")/.."

MODE="${1:-}"

case "$MODE" in
  --wipe)
    echo "Stopping stack and deleting all volumes..."
    docker compose down -v
    ;;
  "")
    echo "Stopping stack (volumes preserved)..."
    docker compose down
    ;;
  *)
    echo "Unknown option: $MODE" >&2
    echo "Usage: $0 [--wipe]" >&2
    exit 1
    ;;
esac
