use `Mryw`;

INSERT IGNORE INTO `Mryw`.`user`
(`id`,`account_name`,`accounturl`,`avatar`,`creation_date`,`email`,`password`,`status_account`)VALUES
(1,'Amen','/amem',null,'2022-02-27','pawel.reclaw@gmail.com','rót','ONLINE');

INSERT IGNORE INTO `Mryw`.`post`
(`id`,`creation_date`,`status_post`,`text`,`creator_post_id`)VALUES
(1,'2022-02-28','ORIGINAL','Mryw jest cool apką!',1);

