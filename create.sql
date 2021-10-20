create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
create table answers (id bigint not null auto_increment, answer varchar(255), email varchar(255), primary key (id)) engine=InnoDB
create table form (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB
create table form_questions (form_id bigint not null, questions_id bigint not null) engine=InnoDB
create table question (id bigint not null auto_increment, all_possible_answers varchar(255), form_type varchar(255), question varchar(255), primary key (id)) engine=InnoDB
create table question_answers (question_id bigint not null, answers_id bigint not null) engine=InnoDB
create table roles (id bigint not null auto_increment, name varchar(60), primary key (id)) engine=InnoDB
create table users (id bigint not null auto_increment, created_at datetime(6) not null, email varchar(255), name varchar(255), password varchar(255), updated_at datetime(6) not null, username varchar(255), role_id bigint, primary key (id)) engine=InnoDB
create table users_forms (users_id bigint not null, forms_id bigint not null) engine=InnoDB
alter table form_questions add constraint UK_7k839ap4840cwsmoxj6e8ecg0 unique (questions_id)
alter table question_answers add constraint UK_4qtn1pf4ea4ougou3ewipk9qx unique (answers_id)
alter table roles add constraint UKofx66keruapi6vyqpv6f2or37 unique (name)
alter table users add constraint UKr43af9ap4edm43mmtq01oddj6 unique (username)
alter table users add constraint UK6dotkott2kjsp8vw4d0m25fb7 unique (email)
alter table users_forms add constraint UK_h1dfuxl57h4ccoa1rq29h5dj unique (forms_id)
alter table form_questions add constraint FKqgc13ev8prhcwgryo0i2bwnn5 foreign key (questions_id) references question (id)
alter table form_questions add constraint FK7w6vy0wl8o5hp9thqmriwehfi foreign key (form_id) references form (id)
alter table question_answers add constraint FK9c1mnvl9wblb8j4d29lwfu708 foreign key (answers_id) references answers (id)
alter table question_answers add constraint FKlglw0r110cw97aje0b0pa4q51 foreign key (question_id) references question (id)
alter table users add constraint FKp56c1712k691lhsyewcssf40f foreign key (role_id) references roles (id)
alter table users_forms add constraint FK2k3o5ph10oscupsh94r3ggmsl foreign key (forms_id) references form (id)
alter table users_forms add constraint FKcsqjv0lsjigb70dnxhd356oih foreign key (users_id) references users (id)
