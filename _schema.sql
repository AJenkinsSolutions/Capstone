CREATE DATABASE projectPilotDb;

USE projectPilotDb; 

CREATE TABLE IF NOT EXISTS `contact` (
	`contact_id` int AUTO_INCREMENT  PRIMARY KEY,
    `name` varchar(100) NOT NULL,
    `mobile_num` varchar(10) NOT NULL,
    `email` varchar(100) NOT NULL,
    `account_type` varchar(50) NOT NULL,
    `message` varchar(500) NOT NULL,
    `status` varchar(10) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `trainings` (
    `day` varchar(20) NOT NULL,
    `training_name` varchar(100) NOT NULL,
    `type` varchar(20) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL
    );
    CREATE TABLE IF NOT EXISTS `roles` (
    `role_id` int NOT NULL AUTO_INCREMENT,
    `role_name` varchar(50) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`role_id`)
    );
    
    CREATE TABLE IF NOT EXISTS `skills` (
    `skills_id` int NOT NULL AUTO_INCREMENT,
    `language` Varchar(50) NOT NULL,
    `front_end` TINYINT(1) NOT NULL DEFAULT 0,
    `back_end` TINYINT(1) NOT NULL DEFAULT 0,
    `ide` varchar(25) DEFAULT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`skills_id`)
    );
    CREATE TABLE IF NOT EXISTS `project` (
    `project_id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`project_id`)
    
    );
    CREATE TABLE IF NOT EXISTS `developer` (
    `developer_id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `email` varchar(50) NOT NULL,
    `mobile_number` varchar(20) NOT NULL,
    `pwd` varchar(200) NOT NULL,
    `role_id` int NOT NULL,
    `skills_id` int NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`developer_id`),
    FOREIGN KEY (role_id) REFERENCES roles(role_id),
    FOREIGN KEY (skills_id) REFERENCES skills(skills_id)
    );

ALTER TABLE `developer`
ADD COLUMN `project_id` int NULL AFTER `skills_id`,
ADD CONSTRAINT `FK_CLASS_PROJECT_ID` FOREIGN KEY (`project_id`)
REFERENCES `project`(`project_id`);
    
CREATE TABLE IF NOT EXISTS `tasks` (
    `task_id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `importance` ENUM('ONE', 'FIVE') NOT NULL DEFAULT 'ONE',
    `project_id` int NULL,
    `created_at` TIMESTAMP NOT NULL,
    `created_by` varchar(50) NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`task_id`),
    FOREIGN KEY (project_id) REFERENCES project(project_id)
    );
    
    
    CREATE TABLE IF NOT EXISTS `project_team` (
    `developer_id` int NOT NULL,
    `task_id` int NOT NULL,
    FOREIGN KEY (developer_id) REFERENCES developer(developer_id),
    FOREIGN KEY (task_id) REFERENCES tasks(task_id),
    PRIMARY KEY (`developer_id`,`task_id`)
    );
    
    
INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
VALUES ('ADMIN',CURDATE(),'DBA');

INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
VALUES ('DEV',CURDATE(),'DBA');
--
-- INSERT INTO `roles` (`role_name`,`created_at`, `created_by`)
-- VALUES ('SKH',CURDATE(),'DBA');


INSERT INTO `developer` (`name`,`email`,`mobile_number`,`pwd`,`role_id`,`created_at`, `created_by`)
VALUES ('Admin','admin@jenkins.com','3443434343','$2a$12$jBpVAVdkO9m3eDGs4Qm7YOe0DDSQ8RbK/i8/ymVTjLseMyfdbn.yy
', 1 ,CURDATE(),'DBA');
    


