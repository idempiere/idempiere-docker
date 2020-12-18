mvn verify -Didempiere.target=org.globalqss.idempiere.LCO.p2.targetplatform

# NOTE: Compilation is configured for jenkins server at ci.idempiere.org
# if needed to compile locally or in a different server setup you need to change relativePath in files:
#   org.globalqss.idempiere.LCO.p2.site/pom.xml
#   org.globalqss.idempiere.LCO.p2.targetplatform/pom.xml
#   org.globalqss.idempiere.LCO.detailednames/pom.xml
#   org.globalqss.idempiere.LCO-feature/pom.xml
#   org.globalqss.idempiere.LCO.invoicenumbercontrol/pom.xml
#   org.globalqss.idempiere.LCO.magneticmedia/pom.xml
#   org.globalqss.idempiere.LCO.withholdings/pom.xml
# and the repository location in file:
#   org.globalqss.idempiere.LCO.p2.targetplatform/org.globalqss.idempiere.LCO.p2.targetplatform.target
