create unique index IX_CB8C59F1 on FE_CJProduct (groupId, sku[$COLUMN_LENGTH:75$]);
create index IX_9DC089D3 on FE_CJProduct (manufacturer[$COLUMN_LENGTH:75$]);
create unique index IX_21BC426A on FE_CJProduct (programName[$COLUMN_LENGTH:75$], catalogName[$COLUMN_LENGTH:75$], sku[$COLUMN_LENGTH:75$]);
create index IX_BF1A5742 on FE_CJProduct (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C673C644 on FE_CJProduct (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E63DBA45 on FE_FtpSubscription (groupId);