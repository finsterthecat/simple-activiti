insert into ACT_ID_USER (ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, PICTURE_ID_)
VALUES
('sally', 2, 'Sally', 'Writer', 'sally@ontario.ca', 'sally', 18);
insert into ACT_ID_USER (ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, PICTURE_ID_)
VALUES
('sammy', 2, 'Sammy', 'Leader', 'sammy@ontario.ca', 'sammy', 7);
insert into ACT_ID_USER (ID_, REV_, FIRST_, LAST_, EMAIL_, PWD_, PICTURE_ID_)
VALUES
('betty', 2, 'Betty', 'Coordinator', 'betty@ontario.ca', 'betty', 22);


insert into ACT_ID_GROUP(ID_, REV_, NAME_, TYPE_)
VALUES
('coordinator', 1, 'CU Coordinator', 'assignment');
insert into ACT_ID_GROUP(ID_, REV_, NAME_, TYPE_)
VALUES
('lead', 1, 'CU Lead', 'assignment');
insert into ACT_ID_GROUP(ID_, REV_, NAME_, TYPE_)
VALUES
('writer', 1, 'CU Writer', 'assignment');


insert into ACT_ID_MEMBERSHIP(USER_ID_, GROUP_ID_)
VALUES
('sally', 'writer');
insert into ACT_ID_MEMBERSHIP(USER_ID_, GROUP_ID_)
VALUES
('sammy', 'lead');
insert into ACT_ID_MEMBERSHIP(USER_ID_, GROUP_ID_)
VALUES
('sammy', 'writer');
insert into ACT_ID_MEMBERSHIP(USER_ID_, GROUP_ID_)
VALUES
('betty', 'coordinator');
insert into ACT_ID_MEMBERSHIP(USER_ID_, GROUP_ID_)
VALUES
('betty', 'lead');
insert into ACT_ID_MEMBERSHIP(USER_ID_, GROUP_ID_)
VALUES
('betty', 'writer');
