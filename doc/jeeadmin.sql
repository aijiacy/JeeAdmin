-- MySQL Script generated by MySQL Workbench
-- 2014年10月12日 星期日 18时14分12秒
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema jeeadmin
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `jeeadmin` ;
CREATE SCHEMA IF NOT EXISTS `jeeadmin` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `jeeadmin` ;

-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_params`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_params` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_params` (
  `uuid` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `value` VARCHAR(300) NOT NULL,
  `desc` VARCHAR(300) NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`uuid`))
ENGINE = InnoDB
COMMENT = '系统参数';

CREATE UNIQUE INDEX `UK_PARAM_NAME` ON `jeeadmin`.`sys_params` (`name` ASC);

CREATE UNIQUE INDEX `UK_PARAM_CODE` ON `jeeadmin`.`sys_params` (`code` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_platforms`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_platforms` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_platforms` (
  `uuid` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `code` VARCHAR(45) NOT NULL,
  `desc` VARCHAR(300) NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`uuid`))
ENGINE = InnoDB
COMMENT = '系统平台';

CREATE UNIQUE INDEX `UK_PFM_NAME` ON `jeeadmin`.`sys_platforms` (`name` ASC);

CREATE UNIQUE INDEX `UK_PFM_CODE` ON `jeeadmin`.`sys_platforms` (`code` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_logs` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_logs` (
  `uuid` VARCHAR(36) NOT NULL,
  `op_name` VARCHAR(45) NULL,
  `op_action` VARCHAR(45) NULL,
  `op_user` VARCHAR(45) NULL,
  `op_desc` VARCHAR(500) NULL,
  `log_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`))
ENGINE = InnoDB
COMMENT = '系统日志';


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_dictionaries`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_dictionaries` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_dictionaries` (
  `uuid` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `value` VARCHAR(100) NULL,
  `type` VARCHAR(10) NULL,
  `pid` VARCHAR(36) NULL DEFAULT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_DICT_PID_ID`
    FOREIGN KEY (`pid`)
    REFERENCES `jeeadmin`.`sys_dictionaries` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `FK_PID_REF_DICT` ON `jeeadmin`.`sys_dictionaries` (`pid` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_user` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_user` (
  `uuid` VARCHAR(36) NOT NULL,
  `realname` VARCHAR(45) NULL COMMENT '真实姓名',
  `nickname` VARCHAR(45) NULL COMMENT '昵称',
  `pic` VARCHAR(45) NULL COMMENT '头像',
  `idcard` VARCHAR(45) NULL COMMENT '身份证',
  `telphone` VARCHAR(45) NULL COMMENT '联系电话',
  `address` VARCHAR(45) NULL COMMENT '地址',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`uuid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_accounts` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_accounts` (
  `uuid` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL COMMENT '账号名',
  `password` VARCHAR(48) NOT NULL COMMENT '账号密码',
  `email` VARCHAR(45) NOT NULL COMMENT '绑定邮箱',
  `mobile` VARCHAR(45) NOT NULL COMMENT '绑定手机',
  `userid` VARCHAR(36) NULL COMMENT '绑定用户',
  `super` INT(11) NOT NULL DEFAULT 0 COMMENT '超级账号',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_ACCOUNT_USER`
    FOREIGN KEY (`userid`)
    REFERENCES `jeeadmin`.`sys_user` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '系统账号';

CREATE INDEX `FK_AU_REF_USER` ON `jeeadmin`.`sys_accounts` (`userid` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_groups` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_groups` (
  `uuid` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `pid` VARCHAR(36) NULL DEFAULT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_GROUP_PID_ID`
    FOREIGN KEY (`pid`)
    REFERENCES `jeeadmin`.`sys_groups` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '系统用户组';

CREATE INDEX `FK_PID_REF_GROUP` ON `jeeadmin`.`sys_groups` (`pid` ASC);

CREATE UNIQUE INDEX `UK_GROUP_NAME` ON `jeeadmin`.`sys_groups` (`name` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_roles` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_roles` (
  `uuid` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`uuid`))
ENGINE = InnoDB
COMMENT = '系统角色';

CREATE UNIQUE INDEX `UK_ROLE_NAME` ON `jeeadmin`.`sys_roles` (`name` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_group_account`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_group_account` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_group_account` (
  `uuid` VARCHAR(36) NOT NULL,
  `groupid` VARCHAR(36) NULL,
  `accid` VARCHAR(36) NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_GU_REF_GROUP`
    FOREIGN KEY (`groupid`)
    REFERENCES `jeeadmin`.`sys_groups` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_GU_REF_ACCOUNT`
    FOREIGN KEY (`accid`)
    REFERENCES `jeeadmin`.`sys_accounts` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `FK_GU_REF_GROUP` ON `jeeadmin`.`sys_group_account` (`groupid` ASC);

CREATE INDEX `FK_GU_REF_ACCOUNT` ON `jeeadmin`.`sys_group_account` (`accid` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_group_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_group_role` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_group_role` (
  `uuid` VARCHAR(36) NOT NULL,
  `groupid` VARCHAR(36) NULL,
  `roleid` VARCHAR(36) NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_GR_REF_GROUP`
    FOREIGN KEY (`groupid`)
    REFERENCES `jeeadmin`.`sys_groups` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_GR_REF_ROLE`
    FOREIGN KEY (`roleid`)
    REFERENCES `jeeadmin`.`sys_roles` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `FK_GR_REF_GROUP` ON `jeeadmin`.`sys_group_role` (`groupid` ASC);

CREATE INDEX `FK_GR_REF_ROLE` ON `jeeadmin`.`sys_group_role` (`roleid` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_acc_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_acc_role` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_acc_role` (
  `uuid` VARCHAR(36) NOT NULL,
  `accid` VARCHAR(36) NULL,
  `roleid` VARCHAR(36) NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_AR_REF_ACCOUNT`
    FOREIGN KEY (`accid`)
    REFERENCES `jeeadmin`.`sys_accounts` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_AR_REF_ROLE`
    FOREIGN KEY (`roleid`)
    REFERENCES `jeeadmin`.`sys_roles` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `FK_AR_REF_ACCOUNT` ON `jeeadmin`.`sys_acc_role` (`accid` ASC);

CREATE INDEX `FK_AR_REF_ROLE` ON `jeeadmin`.`sys_acc_role` (`roleid` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_permissions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_permissions` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_permissions` (
  `uuid` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`uuid`))
ENGINE = InnoDB
COMMENT = '系统权限';

CREATE UNIQUE INDEX `UK_PERMISSION_NAME` ON `jeeadmin`.`sys_permissions` (`name` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_role_permission`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_role_permission` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_role_permission` (
  `uuid` VARCHAR(36) NOT NULL,
  `roleid` VARCHAR(45) NULL,
  `permissionid` VARCHAR(36) NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_RP_REF_ROLE`
    FOREIGN KEY (`roleid`)
    REFERENCES `jeeadmin`.`sys_roles` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_RP_REF_PERMISSION`
    FOREIGN KEY (`permissionid`)
    REFERENCES `jeeadmin`.`sys_permissions` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `FK_RP_REF_ROLE` ON `jeeadmin`.`sys_role_permission` (`roleid` ASC);

CREATE INDEX `FK_RP_REF_PERMISSION` ON `jeeadmin`.`sys_role_permission` (`permissionid` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_menus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_menus` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_menus` (
  `uuid` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NULL,
  `icon` VARCHAR(45) NULL,
  `url` VARCHAR(300) NULL,
  `pid` VARCHAR(36) NULL,
  `platformid` VARCHAR(36) NULL,
  `sort` INT NULL,
  `activate` INT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_MP_REF_PLATFORM`
    FOREIGN KEY (`platformid`)
    REFERENCES `jeeadmin`.`sys_platforms` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '系统菜单';

CREATE INDEX `FK_MP_REF_PLATFORM` ON `jeeadmin`.`sys_menus` (`platformid` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_functions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_functions` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_functions` (
  `uuid` VARCHAR(36) NOT NULL,
  `name` VARCHAR(45) NULL,
  `elemid` VARCHAR(45) NULL,
  `actionType` VARCHAR(45) NULL,
  `actionUrl` VARCHAR(300) NULL,
  `menuid` VARCHAR(36) NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_FM_REF_MENU`
    FOREIGN KEY (`menuid`)
    REFERENCES `jeeadmin`.`sys_menus` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `UK_MF_MENU_ELEM` ON `jeeadmin`.`sys_functions` (`elemid` ASC, `menuid` ASC);

CREATE INDEX `FK_FM_REF_MENU` ON `jeeadmin`.`sys_functions` (`menuid` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_permission_platform`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_permission_platform` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_permission_platform` (
  `uuid` VARCHAR(36) NOT NULL,
  `permissionid` VARCHAR(36) NULL,
  `platformid` VARCHAR(36) NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_PP_REF_PERMISSION`
    FOREIGN KEY (`permissionid`)
    REFERENCES `jeeadmin`.`sys_permissions` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PP_REF_PLATFORM`
    FOREIGN KEY (`platformid`)
    REFERENCES `jeeadmin`.`sys_platforms` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '权限平台';

CREATE INDEX `FK_PP_REF_PERMISSION` ON `jeeadmin`.`sys_permission_platform` (`permissionid` ASC);

CREATE INDEX `FK_PP_REF_PLATFORM` ON `jeeadmin`.`sys_permission_platform` (`platformid` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_permission_menu`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_permission_menu` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_permission_menu` (
  `uuid` VARCHAR(36) NOT NULL,
  `permissionid` VARCHAR(36) NULL,
  `menuid` VARCHAR(36) NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_PM_REF_PERMISSION`
    FOREIGN KEY (`permissionid`)
    REFERENCES `jeeadmin`.`sys_permissions` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PM_REF_MENU`
    FOREIGN KEY (`menuid`)
    REFERENCES `jeeadmin`.`sys_menus` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `FK_PM_REF_PERMISSION` ON `jeeadmin`.`sys_permission_menu` (`permissionid` ASC);

CREATE INDEX `FK_PM_REF_MENU` ON `jeeadmin`.`sys_permission_menu` (`menuid` ASC);


-- -----------------------------------------------------
-- Table `jeeadmin`.`sys_permission_function`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jeeadmin`.`sys_permission_function` ;

CREATE TABLE IF NOT EXISTS `jeeadmin`.`sys_permission_function` (
  `uuid` VARCHAR(36) NOT NULL,
  `permissionid` VARCHAR(36) NULL,
  `functionid` VARCHAR(36) NULL,
  PRIMARY KEY (`uuid`),
  CONSTRAINT `FK_PF_REF_PERMISSION`
    FOREIGN KEY (`permissionid`)
    REFERENCES `jeeadmin`.`sys_permissions` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PF_REF_FUNCTION`
    FOREIGN KEY (`functionid`)
    REFERENCES `jeeadmin`.`sys_functions` (`uuid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `FK_PF_REF_PERMISSION` ON `jeeadmin`.`sys_permission_function` (`permissionid` ASC);

CREATE INDEX `FK_PF_REF_FUNCTION` ON `jeeadmin`.`sys_permission_function` (`functionid` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
