create table qualitytrack_Release (
	releaseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	releaseName VARCHAR(75) null,
	releaseDate DATE null
);

create table qualitytrack_TestCase (
	testCaseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	testCaseName VARCHAR(75) null,
	automatic BOOLEAN,
	steps VARCHAR(75) null,
	categroyId LONG,
	expectedResults VARCHAR(75) null
);