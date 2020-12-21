set -x

cat /languages/LangPairs | while read ID_LANG ID_FOLDER ID_URL
do
    echo "*** Adding language $ID_LANG from folder $ID_FOLDER *** - $(date +'%Y-%m-%d %H:%M:%S')"
    cd /languages
    git clone $ID_URL $ID_FOLDER
    cd "$ID_FOLDER"
    cd /$IDEMPIERE_HOME/utils
    psql -h $DB_HOST -U $DB_USER -d $DB_NAME -c "UPDATE AD_Language SET IsSystemLanguage='Y', IsLoginLocale='Y' WHERE AD_Language='$ID_LANG'"
    bash RUN_TrlImport.sh $ID_LANG $ID_FOLDER
done
cd /$IDEMPIERE_HOME/utils
echo "*** Synchronize Terminology *** - $(date +'%Y-%m-%d %H:%M:%S')"
bash RUN_SyncTerm.sh 
