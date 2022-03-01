CREATE TABLE superheroes (
  id BIGSERIAL,
  name VARCHAR(255) UNIQUE NOT NULL,
  real_name VARCHAR(255),
  power float8,
  PRIMARY KEY (id)
);