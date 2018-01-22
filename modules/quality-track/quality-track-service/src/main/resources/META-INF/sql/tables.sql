create table qualitytrack_Release (
	releaseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	releaseName VARCHAR(75) null,
	releaseDate DATE null,
	isDefault BOOLEAN,
	status INTEGER,
	comments VARCHAR(75) null
);

create table qualitytrack_Test (
	testId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	releaseId LONG,
	testCaseId LONG,
	actualResults VARCHAR(75) null,
	jiraLink VARCHAR(75) null,
	time_ LONG,
	comments VARCHAR(75) null
);

create table qualitytrack_TestCase (
	testCaseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	environment VARCHAR(75) null,
	testCaseName VARCHAR(75) null,
	beforeTestCaseId LONG,
	automatic BOOLEAN,
	afterTestCaseId LONG,
	steps STRING null,
	categroyId LONG,
	expectedResults STRING null,
	comments VARCHAR(75) null,
	developer VARCHAR(75) null,
	developerId LONG
);

create table qualitytrack_TestCases_Releases (
	companyId LONG not null,
	releaseId LONG not null,
	testCaseId LONG not null,
	primary key (releaseId, testCaseId)
);