create index IX_CFFD06FF on FOO_Foo (field2);
create index IX_B2FCA947 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_905CD589 on FOO_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_3DA59EDB on cafe_CJProduct (groupId, urlTitle[$COLUMN_LENGTH:75$]);
create index IX_CC0F8131 on cafe_CJProduct (manufacturer[$COLUMN_LENGTH:75$]);
create unique index IX_87EB32CC on cafe_CJProduct (programName[$COLUMN_LENGTH:75$], catalogName[$COLUMN_LENGTH:75$], sku[$COLUMN_LENGTH:75$]);
create index IX_B4426FA0 on cafe_CJProduct (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_9CE25E22 on cafe_CJProduct (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_81CDAEA7 on cafe_FtpSubscription (groupId);