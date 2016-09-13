/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/7/17 1:01:41                            */
/*==============================================================*/


drop table if exists Autority_Table;

drop table if exists Menu_Table;

drop table if exists Role_Table;

drop table if exists UserRole_Table;

drop table if exists User_Table;

/*==============================================================*/
/* Table: Autority_Table                                        */
/*==============================================================*/
create table Autority_Table
(
   ID                   int not null   auto_increment comment '权限ID',
   MENUID               int not null comment '菜单ID',
   ROLEID               int not null comment '角色ID',
   primary key (ID)
);

alter table Autority_Table comment '权限表：关联角色表和菜单表
';

/*==============================================================*/
/* Table: Menu_Table                                            */
/*==============================================================*/
create table Menu_Table
(
   ID                   int not null auto_increment comment '菜单ID' ,
   MENUNAME             varchar(10) comment '菜单名称',
   PARENTMENUID         int comment '父菜单ID',
   primary key (ID)
);

alter table Menu_Table comment '菜单表：用来添加菜单';

/*==============================================================*/
/* Table: Role_Table                                            */
/*==============================================================*/
create table Role_Table
(
   ID                   int not null   auto_increment comment '角色ID',
   ROLENAME             varchar(20) comment '角色名',
   DESCRIPTION          varchar(50) comment '描述',
   primary key (ID)
);

alter table Role_Table comment '角色表';

/*==============================================================*/
/* Table: UserRole_Table                                        */
/*==============================================================*/
create table UserRole_Table
(
   ID                   int not null   auto_increment comment '主键ID',
   ROLEID               int not null comment '角色ID',
   USERID               INT not null comment '用户ID',
   primary key (ID)
);

alter table UserRole_Table comment '用户角色表：用户表和角色表的中间表';

/*==============================================================*/
/* Table: User_Table                                            */
/*==============================================================*/
create table User_Table
(
   ID                   int not null   auto_increment comment '用户ID',
   USERNAME             varchar(20) comment '用户名',
   PASSWORD             varchar(20) comment '用户密码',
   NICKNAME             varchar(20) comment '昵称',
   primary key (ID)
);

alter table User_Table comment '用户表';

alter table Autority_Table add constraint FK_Reference_3 foreign key (MENUID)
      references Menu_Table (ID) on delete restrict on update restrict;

alter table Autority_Table add constraint FK_Reference_4 foreign key (ROLEID)
      references Role_Table (ID) on delete restrict on update restrict;

alter table UserRole_Table add constraint FK_Reference_1 foreign key (USERID)
      references User_Table (ID) on delete restrict on update restrict;

alter table UserRole_Table add constraint FK_Reference_2 foreign key (ROLEID)
      references Role_Table (ID) on delete restrict on update restrict;

