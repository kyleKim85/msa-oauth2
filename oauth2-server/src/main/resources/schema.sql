-- used in tests that use HSQL
create table oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

create table oauth_client_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication LONGVARBINARY,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication LONGVARBINARY
);

create table oauth_code (
  code VARCHAR(256), authentication LONGVARBINARY
);

create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);

--custom table
CREATE TABLE user (
  id INT NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(100) NOT NULL,
  role varchar(20) NOT NULL,
  created_date date,
  modified_date date,
  PRIMARY KEY (id),
  UNIQUE KEY username (username)
);

--test data
insert into user (username, password
, role, created_date, modified_date) 
values('admin','$2a$10$TJu2xikowt6DIt3qJ3uglem3QJrTBQTz3pZu4Y.FaaT6JbXvbX/qa'
,'ROLE_ADMIN', now(), now());

insert into user (username, password
, role, created_date, modified_date) 
values('user','$2a$10$TJu2xikowt6DIt3qJ3uglem3QJrTBQTz3pZu4Y.FaaT6JbXvbX/qa'
,'ROLE_USER', now(), now());


insert into oauth_client_details (client_id, client_secret,
    resource_ids, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information,
    autoapprove)
  values ('client', '$2a$10$TJu2xikowt6DIt3qJ3uglem3QJrTBQTz3pZu4Y.FaaT6JbXvbX/qa',
    null, 'read', 'authorization_code,implicit,password,client_credentials,refresh_token',
    'http://localhost:8080/login' , 'CLIENT', 36000,
    2592000, null,
    'false');
    
insert into oauth_client_details (client_id, client_secret,
    resource_ids, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information,
    autoapprove)
  values ('client1', '$2a$10$TJu2xikowt6DIt3qJ3uglem3QJrTBQTz3pZu4Y.FaaT6JbXvbX/qa',
    null, 'read', 'authorization_code,implicit,password,client_credentials,refresh_token',
    'http://localhost:8080/login/kakao' , 'CLIENT', 36000,
    2592000, null,
    'false');
    
    