DROP TABLE IF EXISTS t_ucm_user;
CREATE TABLE t_ucm_user(
  username varchar(32) PRIMARY KEY,

);
DROP TABLE IF EXISTS t_ucm_role;
CREATE TABLE t_ucm_role (
  id   INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(64) NOT NULL,
  code VARCHAR(32) NOT NULL,
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp,
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP
);