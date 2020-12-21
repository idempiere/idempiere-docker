KEY_STORE_PASS=${KEY_STORE_PASS:-myPassword}
KEY_STORE_ON=${KEY_STORE_ON:-idempiere.org}
KEY_STORE_OU=${KEY_STORE_OU:-iDempiere Docker}
KEY_STORE_O=${KEY_STORE_O:-iDempiere}
KEY_STORE_L=${KEY_STORE_L:-myTown}
KEY_STORE_S=${KEY_STORE_S:-CA}
KEY_STORE_C=${KEY_STORE_C:-US}
DB_HOST=${DB_HOST:-postgres}
DB_PORT=${DB_PORT:-5432}
DB_NAME=${DB_NAME:-idempiere}
DB_USER=${DB_USER:-adempiere}
DB_PASS=${DB_PASS:-adempiere}
DB_ADMIN_PASS=${DB_ADMIN_PASS:-postgres}

cat /languages/LangPairs | while read ID_LANG ID_FOLDER ID_URL
do
   set -x
    echo "*** Adding language $ID_LANG from folder $ID_FOLDER *** - $(date +'%Y-%m-%d %H:%M:%S')"
    cd /languages
    git clone $ID_URL $ID_FOLDER
    cd "$ID_FOLDER"
    cd /$IDEMPIERE_HOME/utils
    PGPASSWORD=$DB_PASS psql -h $DB_HOST -U $DB_USER -d $DB_NAME -c "UPDATE AD_Language SET IsSystemLanguage='Y', IsLoginLocale='Y' WHERE AD_Language='$ID_LANG'"
    bash RUN_TrlImport.sh $ID_LANG $ID_FOLDER
done
cd /$IDEMPIERE_HOME/utils
echo "*** Synchronize Terminology *** - $(date +'%Y-%m-%d %H:%M:%S')"
bash RUN_SyncTerm.sh
