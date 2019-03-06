CREATE TABLE user (
                    id   BIGINT(20)      NOT NULL,
                    username VARCHAR(255),
                    password VARCHAR(255),
                    type VARCHAR(255),
                    status VARCHAR(255),
                    PRIMARY KEY (id)
);

CREATE TABLE worker (
                      id   BIGINT(20)      NOT NULL,
                      name VARCHAR(255),
                      last_name VARCHAR(255),
                      status VARCHAR(255),
                      PRIMARY KEY (id)
);

CREATE TABLE worker_users (
                            worker_id   BIGINT(20)      NOT NULL,
                            user_id   INTEGER      NOT NULL,
                            PRIMARY KEY (worker_id,user_id)
);
CREATE TABLE hibernate_sequence (
  next_val   BIGINT(20)
);