create table FE_CJProduct (
	uuid_ VARCHAR(75) null,
	productId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	programName VARCHAR(75) null,
	catalogName VARCHAR(75) null,
	sku VARCHAR(75) null,
	programUrl VARCHAR(75) null,
	lastUpdated VARCHAR(75) null,
	name VARCHAR(75) null,
	keywords VARCHAR(75) null,
	description VARCHAR(75) null,
	manufacturer VARCHAR(75) null,
	manufacturerId VARCHAR(75) null,
	currency_ VARCHAR(75) null,
	price VARCHAR(75) null,
	buyUrl VARCHAR(75) null,
	impressionUrl VARCHAR(75) null,
	imageUrl VARCHAR(75) null,
	inStock VARCHAR(75) null,
	viewCount INTEGER
);

create table FE_FtpSubscription (
	ftpSubscriptionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ftpHost VARCHAR(75) null,
	ftpUser VARCHAR(75) null,
	ftpPassword VARCHAR(75) null,
	ftpFolder VARCHAR(75) null,
	ftpFile VARCHAR(75) null,
	ftpDatafeedName VARCHAR(75) null,
	ftpDatafeedDescription VARCHAR(75) null
);