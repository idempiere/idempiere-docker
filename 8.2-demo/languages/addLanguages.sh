set -x

cat /languages/LangPairs | while read ID_LANG ID_FOLDER
do
    echo "*** Adding language $ID_LANG from folder $ID_FOLDER *** - $(date +'%Y-%m-%d %H:%M:%S')"
    cd "$ID_FOLDER"
    if git rev-parse --is-inside-work-tree > /dev/null 2>&1
    then
	git pull -v
    elif hg -q stat > /dev/null 2>&1
    then
	hg -v pull -u
    else
	echo "$ID_FOLDER is not git or hg.  *** VERIFY how to update ***"
    fi
    cd /$IDEMPIERE_HOME/utils
    psql -h $DB_HOST -U $DB_USER -d $DB_NAME -c "UPDATE AD_Language SET IsSystemLanguage='Y', IsLoginLocale='Y' WHERE AD_Language='$ID_LANG'"
    bash RUN_TrlImport.sh $ID_LANG $ID_FOLDER
done
cd /$IDEMPIERE_HOME/utils
echo "*** Synchronize Terminology *** - $(date +'%Y-%m-%d %H:%M:%S')"
bash RUN_SyncTerm.sh 
