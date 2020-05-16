--   Jon Snow    hasło - Duch123
INSERT INTO account (username, first_name, last_name, password, email, is_active) VALUES ('JonBękart12', 'Jon', 'Snow', '$2y$12$3fd99QFLRdLLDJyKB3OtGe2T6paUS66hePAzMEUWAX4yyyJxOAT/S','duch@o2.pl',true);
INSERT INTO account (username, first_name, last_name, password, email, is_active) VALUES ('ObiKenobi14', 'Obi-Wan', 'Kenobi', '$2y$12$3fd99QFLRdLLDJyKB3OtGe2T6paUS66hePAzMEUWAX4yyyJxOAT/S','obibobi@o2.pl',true);
INSERT INTO account (username, first_name, last_name, password, email, is_active) VALUES ('$$VADER$$', 'Anakin', 'Skywalker', '$2y$12$3fd99QFLRdLLDJyKB3OtGe2T6paUS66hePAzMEUWAX4yyyJxOAT/S','vader@02.pl',true);
INSERT INTO account (username, first_name, last_name, password, email, is_active) VALUES ('Ksiezniczka123', 'Leia', 'Organa', '$2y$12$3fd99QFLRdLLDJyKB3OtGe2T6paUS66hePAzMEUWAX4yyyJxOAT/S','leia@o2.pl',true);

INSERT INTO post (lob, description, add_date,account_id) VALUES (FILE_READ('classpath:images/jonsnowseedog.jpg'),'Fajny pieseł, chyba nazwę go Duch',{ts '2012-09-17 18:47:52.69'},1);
INSERT INTO post (lob, description, add_date,account_id) VALUES (FILE_READ('classpath:images/firsttimewithygritte.jpg'),'Złapałem jakąś dzikuske, mówi że nazywa się Ygritte',{ts '2014-09-17 18:47:52.69'},1);
INSERT INTO post (lob, description, add_date,account_id) VALUES (FILE_READ('classpath:images/jonsnowoathwithsam.jpg'),'Przysięga z Samem do nocnej straży',{ts '2013-09-17 18:47:52.69'},1);
INSERT INTO post (lob, description, add_date,account_id) VALUES (FILE_READ('classpath:images/jonsnofirsttimeonwall.jpg'),'Pierwszy raz na murze, ale wysoko',{ts '2013-12-17 18:47:52.69'},1);

INSERT INTO comment (content, add_date, account_id, post_id) VALUES ('Ehh kiedyś to było, teraz to strzela do mnie z łuku...', {ts '2015-02-17 18:47:52.69'},1,2);
INSERT INTO comment (content, add_date, account_id, post_id) VALUES ('Komentarz 2 ', {ts '2015-04-17 18:47:52.69'},1,2);
INSERT INTO comment (content, add_date, account_id, post_id) VALUES ('Komentarz 3 ', {ts '2015-03-17 18:47:52.69'},1,2);

INSERT INTO post (lob, description, add_date,account_id) VALUES (FILE_READ('classpath:images/ben1.jpg'),'Ale jestem przystojniacha',{ts '1997-07-19 13:47:32.69'},2);
INSERT INTO post (lob, description, add_date,account_id) VALUES (FILE_READ('classpath:images/Ben_Kenobi.jpg'),'To ja staje do walki',{ts '1997-07-19 18:47:32.69'},2);

INSERT INTO comment (content, add_date, account_id, post_id) VALUES ('No nie da się ukryć ;) ', {ts '1997-08-19 18:47:32.69'},4,5);
INSERT INTO comment (content, add_date, account_id, post_id) VALUES ('Haha człowieku jak ty rozwalony zostałeś wtedy', {ts '1997-09-19 18:47:32.69'},3,6);

INSERT INTO post (lob, description, add_date,account_id) VALUES (FILE_READ('classpath:images/vader.jpg'),'Nie zadzierać ze mną bo to będzie ostatnia rzecz, która zobaczycie !!',{ts '1997-07-19 17:47:32.69'},3);
INSERT INTO post (lob, description, add_date,account_id) VALUES (FILE_READ('classpath:images/vader_leia.jpg'),'Córcia znowu narozrabiała to trzeba pouczyć',{ts '1997-07-19 15:47:32.69'},3);

INSERT INTO comment (content, add_date, account_id, post_id) VALUES ('No weź się tato', {ts '1997-09-19 15:47:32.69'},4,8);

INSERT INTO post (lob, description, add_date,account_id) VALUES (FILE_READ('classpath:images/leia.jpg'),'Pif paf haha',{ts '1997-07-19 15:47:32.69'},3);

INSERT INTO comment (content, add_date, account_id, post_id) VALUES ('Wow super!', {ts '1997-09-21 15:47:32.69'},3,9);

INSERT INTO topic (title, account_id) VALUES ('Proponuję żęby każdy coś tu napisał o sobie :)', 1);
INSERT INTO forum_post (content, account_id, topic_id) VALUES ('To może ja zaczne jestem Jon ', 1,1);
INSERT INTO forum_post (content, account_id, topic_id) VALUES ('Ja jestem Obi-Wan Kenobi potężny Jedi i znawca mocy', 2,1);
INSERT INTO forum_post (content, account_id, topic_id) VALUES ('Ja jestem Lord Vader i bardzo nie lubie tych wszystkich Jedi...', 3,1);
INSERT INTO forum_post (content, account_id, topic_id) VALUES ('Jestem przwódczyni rebeliantów Księżniczka Leia !!', 4,1);

INSERT INTO topic (title, account_id) VALUES ('Jakieś rady jak zwalczyć rebeliantów', 3);
INSERT INTO forum_post (content, account_id, topic_id) VALUES ('Ja wiem ale nie powiem haha', 4,2);