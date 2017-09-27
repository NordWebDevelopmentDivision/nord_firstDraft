-- Insert role
insert into role (name) values ('ROLE_USER');
insert into role (name) values ('ROLE_ADMIN');

-- Insert two users (passwords are both 'password')
insert into member (username,enabled,password,role_id) values ('user',true,'$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u',1);
insert into member (username,enabled,password,role_id) values ('user2',true,'$2a$08$wgwoMKfYl5AUE9QtP4OjheNkkSDoqDmFGjjPE2XTPLDe9xso/hy7u',1);
insert into member (username,enabled,password,role_id) values ('admin',true,'$2a$04$AtNR0m22saiPGH.nXeyFzOlceL728DPDlEhO.EJe7CA8ISMcryls2',2);
