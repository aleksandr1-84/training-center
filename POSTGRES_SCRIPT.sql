/*Создание таблиц*/

create table "Employee" (
	"EmpID" 	serial primary key, /*Autoincrement реализован с помощью типа serial*/
	"Name" 		character varying(20),
	"Department" 	character varying(20)
);

create table "Company" (
	"Name" character varying(20) primary key
);

create table "Project" (
	"Name" 		character varying(20) primary key,
	"Company" 	character varying(20) references "Company"("Name") 
				on delete set null 
				on update cascade,
	"ManagerID" 	bigint references "Employee"("EmpID") 
				on delete set null 
				on update cascade
);

create table "EmpToProject" (
	"EmpID"	bigint references "Employee"("EmpID") 
			on delete cascade 
			on update cascade,
	"Name" character varying(20) references "Project"("Name") 
			on delete cascade 
			on update cascade,
	primary key ("EmpID","Name")
);

/*Добавить constraint после создания таблицы*/

alter table "Employee" add constraint "employee_name_unique" unique ("Name");

/*Наполнение*/

insert into "Employee" values (default, 'Steve Black', 'HR');
insert into "Employee" values (default, 'Lisa Johns', 'HR');
insert into "Employee" values (default, 'Michael Ridley', 'Development');
insert into "Employee" values (default, 'Marie Gosling', 'Development');
insert into "Employee" values (default, 'Paul Darling', 'Management');
insert into "Employee" values (default, 'Donald Smith', 'Management');

insert into "Company" values ('Google');
insert into "Company" values ('Microsoft');

insert into "Project" values (
	'Youtube', 
	'Google', 
	(select "EmpID" 
		from "Employee" 
		where "Name" = 'Michael Ridley'
	)
);
insert into "Project" values (
	'Windows 10', 
	'Microsoft', 
	(select "EmpID" 
		from "Employee" 
		where "Name" = 'Marie Gosling'
	)
);

insert into "EmpToProject" values (
	(select "EmpID" 
		from "Employee" 
		where "Name" = 'Lisa Johns'
	), 
	'Youtube'
);
insert into "EmpToProject" values (
	(select "EmpID" 
		from "Employee" 
		where "Name" = 'Donald Smith'
	), 
	'Youtube'
);
insert into "EmpToProject" values (
	(select "EmpID" 
		from "Employee" 
		where "Name" = 'Steve Black'
	), 
	'Windows 10'
);
insert into "EmpToProject" values (
	(select "EmpID" 
		from "Employee" 
		where "Name" = 'Paul Darling'
	), 
	'Windows 10'
);

/*Примеры select запросов*/

/*Для каждого сотрудника вывести названия проектов, в которых он участвует и название их компании*/
select e."Name",
       p."Name",
       p."Company"
 from "Employee" e
      left outer join "EmpToProject" etp
	on e."EmpID" = etp."EmpID"
      left outer join "Project" p
	on etp."Name" = p."Name"
;

/*Для каждой компании вывести её проекты*/
select c."Name",
       p."Name"
 from "Company" c
      left outer join "Project" p
       on c."Name" = p."Company"
 ;