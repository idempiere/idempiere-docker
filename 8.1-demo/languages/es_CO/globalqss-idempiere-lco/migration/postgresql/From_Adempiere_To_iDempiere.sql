delete from ad_modelvalidator where modelvalidationclass='org.globalqss.model.LCO_Validator'
;

update ad_column set callout = null where callout like 'org.globalqss.model.LCO_Callouts.%'
;

update ad_column set callout = null where callout like 'org.globalqss.model.LCO_CalloutWithholding.%'
;

update ad_column set callout='org.compiere.model.CalloutCashJournal.invoice;org.compiere.model.CalloutCashJournal.amounts' where ad_column_id=5354  -- C_CashLine.C_Invoice_ID
;

update ad_column set callout='org.compiere.model.CalloutPayment.invoice;org.compiere.model.CalloutPayment.amounts' where ad_column_id=5355  -- C_Payment.C_Invoice_ID
;

update ad_column set callout='org.compiere.model.CalloutPaymentAllocate.invoice;org.compiere.model.CalloutPaymentAllocate.amounts' where ad_column_id=14328  -- C_PaymentAllocate.C_Invoice_ID
;
