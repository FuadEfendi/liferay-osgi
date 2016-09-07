create unique index IX_8DCAAB79 on FE_CJProduct (groupId, urlTitle[$COLUMN_LENGTH:75$]);
create index IX_9DC089D3 on FE_CJProduct (manufacturer[$COLUMN_LENGTH:75$]);
create unique index IX_21BC426A on FE_CJProduct (programName[$COLUMN_LENGTH:75$], catalogName[$COLUMN_LENGTH:75$], sku[$COLUMN_LENGTH:75$]);
create index IX_BF1A5742 on FE_CJProduct (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_C673C644 on FE_CJProduct (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_E63DBA45 on FE_FtpSubscription (groupId);

create index IX_CFFD06FF on FOO_Foo (field2);
create index IX_B2FCA947 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_905CD589 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_2A7B0DF6 on SSB_CJProduct (groupId, urlTitle[$COLUMN_LENGTH:75$]);
create index IX_9151CD36 on SSB_CJProduct (manufacturer[$COLUMN_LENGTH:75$]);
create unique index IX_D4E3D167 on SSB_CJProduct (programName[$COLUMN_LENGTH:75$], catalogName[$COLUMN_LENGTH:75$], sku[$COLUMN_LENGTH:75$]);
create index IX_37C53125 on SSB_CJProduct (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1AC1BCE7 on SSB_CJProduct (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_64D4E342 on SSB_FtpSubscription (groupId);

create unique index IX_3DA59EDB on cafe_CJProduct (groupId, urlTitle[$COLUMN_LENGTH:75$]);
create index IX_CC0F8131 on cafe_CJProduct (manufacturer[$COLUMN_LENGTH:75$]);
create unique index IX_87EB32CC on cafe_CJProduct (programName[$COLUMN_LENGTH:75$], catalogName[$COLUMN_LENGTH:75$], sku[$COLUMN_LENGTH:75$]);
create index IX_B4426FA0 on cafe_CJProduct (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9CE25E22 on cafe_CJProduct (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_81CDAEA7 on cafe_FtpSubscription (groupId);