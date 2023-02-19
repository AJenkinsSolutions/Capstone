use projectPilotDb;

INSERT INTO `trainings` (`day`, `training_name`, `type`, `created_at`, `created_by`)
VALUES ('Jan 15', 'Java Fundamentals', 'FUNDAMENTALS', CURDATE(), 'DBA');

INSERT INTO `trainings` (`day`, `training_name`, `type`, `created_at`, `created_by`)
VALUES ('Feb 1', 'Spring Boot Essentials', 'ESSENTIALS', CURDATE(), 'DBA');

INSERT INTO `trainings` (`day`, `training_name`, `type`, `created_at`, `created_by`)
VALUES ('Mar 10', 'Advanced Database Concepts', 'ADVANCED', CURDATE(), 'DBA');

INSERT INTO `trainings` (`day`, `training_name`, `type`, `created_at`, `created_by`)
VALUES ('Apr 5', 'Web Development with React', 'DEVELOPMENT', CURDATE(), 'DBA');

INSERT INTO `trainings` (`day`, `training_name`, `type`, `created_at`, `created_by`)
VALUES ('May 20', 'Agile Project Management', 'PROJECT', CURDATE(), 'DBA');

INSERT INTO `trainings` (`day`, `training_name`, `type`, `created_at`, `created_by`)
VALUES ('Jun 15', 'Python Programming', 'FUNDAMENTALS', CURDATE(), 'DBA');

INSERT INTO `trainings` (`day`, `training_name`, `type`, `created_at`, `created_by`)
VALUES ('Jul 5', 'Web Security Fundamentals', 'ESSENTIALS', CURDATE(), 'DBA');

INSERT INTO `trainings` (`day`, `training_name`, `type`, `created_at`, `created_by`)
VALUES ('Aug 20', 'AWS Solutions Architect', 'ADVANCED', CURDATE(), 'DBA');

INSERT INTO `developer` (`name`,`email`,`mobile_number`,`pwd`,`role_id`,`created_at`, `created_by`)
VALUES ('Admin','admin@jenkins.com','3443434343','$2a$12$jBpVAVdkO9m3eDGs4Qm7YOe0DDSQ8RbK/i8/ymVTjLseMyfdbn.yy
', 1 ,CURDATE(),'DBA');