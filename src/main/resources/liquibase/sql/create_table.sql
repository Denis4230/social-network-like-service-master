--liquibase formatted sql
--changeset semenovdo:SN4-create-table

CREATE TABLE IF NOT EXISTS snlike.post_likes
(
    id       BIGSERIAL NOT NULL,
    post_id   BIGINT    NOT NULL,
    user_id   BIGINT    NOT NULL,
    positive boolean DEFAULT false,
    PRIMARY KEY (id)
);

CREATE INDEX IF NOT EXISTS post_id_index ON  snlike.post_likes  (post_id);

CREATE TABLE IF NOT EXISTS snlike.comment_likes
(
    id        BIGSERIAL NOT NULL,
    comment_id BIGINT    NOT NULL,
    user_id    BIGINT    NOT NULL,
    positive  boolean DEFAULT false,
    PRIMARY KEY (id)
);
