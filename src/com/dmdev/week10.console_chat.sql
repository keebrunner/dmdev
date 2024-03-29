CREATE DATABASE console_chat_repository;

CREATE SCHEMA chat_storage;

CREATE TABLE IF NOT EXISTS users
(
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(50) UNIQUE  NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP           NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS user_profile
(
    id              SERIAL PRIMARY KEY,
    user_id         INTEGER REFERENCES users (id) NOT NULL,
-- Это аватар в виде UTF-смайла, по умолчанию E'\\U0001F468'
    profile_picture VARCHAR(255)                           DEFAULT E'\U0001F468',
-- Это краткое 'о себе', типа 'Дизайнер из Петербурга, 23 года.'
    bio             TEXT CHECK (length(bio) <= 100)        DEFAULT '',
    created_at      TIMESTAMP                     NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS user_settings
(
    id                 SERIAL PRIMARY KEY,
    user_id            INTEGER REFERENCES users (id) NOT NULL,
    notification_sound BOOLEAN DEFAULT true,
    notification_sound_file_path TEXT DEFAULT '%APPDATA%\console_chat_repository\notification_sound.wav',
    dark_mode          BOOLEAN DEFAULT false
);

CREATE TABLE IF NOT EXISTS friendship
(
    id        SERIAL PRIMARY KEY,
    user_id   INTEGER REFERENCES users (id) NOT NULL,
    friend_id INTEGER REFERENCES users (id) NOT NULL,
    UNIQUE (user_id, friend_id)
);

CREATE TABLE IF NOT EXISTS user_friendship
(
    user_id   INTEGER REFERENCES users (id) NOT NULL,
    friend_id INTEGER REFERENCES users (id) NOT NULL,
    PRIMARY KEY (user_id, friend_id)
);

CREATE TABLE IF NOT EXISTS chat
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255)                  NOT NULL,
    created_by INTEGER REFERENCES users (id) NOT NULL,
    created_at TIMESTAMP                     NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS chat_member
(
    chat_id   INTEGER REFERENCES chat (id)  NOT NULL,
    user_id   INTEGER REFERENCES users (id) NOT NULL,
    joined_at TIMESTAMP                     NOT NULL DEFAULT NOW(),
    PRIMARY KEY (chat_id, user_id)
);

CREATE TABLE IF NOT EXISTS message
(
    id         SERIAL PRIMARY KEY,
    chat_id    INTEGER REFERENCES chat (id)  NOT NULL,
    user_id    INTEGER REFERENCES users (id) NOT NULL,
    text       TEXT                          NOT NULL,
    created_at TIMESTAMP                     NOT NULL DEFAULT NOW()
);

INSERT INTO users (username, password, email)
VALUES ('Carl_Hewitt', 'Ff4vY2nM8L', 'carl_hewitt@computerscience.com'),
       ('Donald_Knuth', 'Sj1bW8zE3P', 'donald_knuth@stanford.edu'),
       ('Barbara_Liskov', 'Kt6gC7mF5Z', 'barbara_liskov@mit.edu'),
       ('Martin_Odersky', 'Dn8kG2fE1L', 'martin_odersky@epfl.ch'),
       ('Andrey_Breslav', 'Xc5pM7dR1N', 'andrey_breslav@jetbrains.com'),
       ('Yoshua_Bengio', 'Yr7nF5tJ3D', 'yoshua_bengio@umontreal.ca'),
       ('Demis_Hassabis', 'Uv2bG8mF5P', 'demis_hassabis@deepmind.com');

INSERT INTO user_profile (user_id, profile_picture, bio)
VALUES (1, E'\U0001F468', 'Java enthusiast and performance optimizer'),
       (2, E'\U0001F47E', 'Computer scientist and algorithm designer'),
       (3, E'\U0001F469', 'Programming language researcher and inventor'),
       (4, E'\U0001F468\u200D\U0001F4BB', 'Scala creator and functional programming advocate'),
       (5, E'\U0001F47D', 'Deep learning and AI pioneer'),
       (6, E'\U0001F469\u200D\U0001F3EB', 'CEO of DeepMind and AI visionary'),
       (7, E'\U0001F468\u200D\U0001F4BB', 'Computer science professor and programming language designer');

INSERT INTO user_settings (user_id, notification_sound, dark_mode)
VALUES (1, true, false),
       (2, false, true),
       (3, true, true),
       (4, false, false),
       (5, true, false),
       (6, false, true),
       (7, true, true);

INSERT INTO friendship (user_id, friend_id)
VALUES (1, 2),
       (1, 3),
       (2, 1),
       (2, 3),
       (3, 1),
       (3, 2),
       (4, 2),
       (5, 6),
       (6, 5),
       (5, 7),
       (7, 5);

INSERT INTO user_friendship (user_id, friend_id)
SELECT user_id, friend_id
FROM friendship
UNION
SELECT friend_id, user_id
FROM friendship;

INSERT INTO chat (name, created_by)
VALUES ('Java Performance Optimization', 1),
       ('Java Concurrency and Multithreading', 2),
       ('Java Virtual Machine Internals', 3),
       ('Theoretical Computer Science and Algorithms', 4),
       ('Sci-Fi Lounge', 5);

INSERT INTO chat_member (chat_id, user_id)
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (2, 1),
       (2, 2),
       (2, 3),
       (3, 1),
       (3, 2),
       (3, 3),
       (4, 1),
       (4, 2),
       (4, 4),
       (5, 5),
       (5, 6),
       (5, 7),
       (5, 3),
       (5, 4);

INSERT INTO message (chat_id, user_id, text)
VALUES (1, 1, 'Has anyone benchmarked the latest Java 19 release for CPU-intensive workloads?'),
       (1, 2,
        'I have, and I found that using primitives instead of boxed types can significantly improve performance.'),
       (1, 3,
        'Interesting, have you also tried using the new records feature? It can simplify code and improve performance.'),
       (2, 1, 'What are the best practices for thread synchronization in Java?'),
       (2, 2,
        'Avoid using synchronized blocks if possible, and instead use higher-level constructs such as java.util.concurrent.atomic.'),
       (3, 3, 'What happens under the hood when the JVM compiles and executes Java bytecode?'),
       (3, 1, 'There are many steps involved, including parsing, verification, optimization, and code generation.'),
       (4, 4, 'Has anyone here worked on the Travelling Salesman Problem or other NP-complete problems?'),
       (4, 2, 'Yes, I have used branch and bound and genetic algorithms to solve the TSP.'),
       (5, 5, 'What are your thoughts on "Snow Crash" by Neal Stephenson?'),
       (5, 6, 'I enjoyed it, but I found the portrayal of technology to be overly optimistic.'),
       (5, 7,
        'I appreciate how it blended science fiction and philosophy, and challenged our ideas about language and communication. It is a true masterpiece!');

SELECT *
FROM user_profile
WHERE user_id = (SELECT id FROM users WHERE username = 'Donald_Knuth');

SELECT *
FROM users
WHERE id IN
      (SELECT friend_id FROM user_friendship WHERE user_id = (SELECT id FROM users WHERE username = 'Barbara_Liskov'));

SELECT chat.*
FROM chat_member
         JOIN chat ON chat.id = chat_member.chat_id
WHERE chat_member.user_id = (SELECT id FROM users WHERE username = 'Andrey_Breslav');

SELECT COUNT(*)
FROM message
WHERE chat_id = (SELECT id FROM chat WHERE name = 'Java Performance Optimization');

INSERT INTO users (username, password, email)
VALUES ('Eve_Marder', 'Pn8bW6tF2L', 'eve_marder@brandeis.edu'),
       ('Michael_Häusser', 'Gh5fS2jD1M', 'michael_hausser@ucl.ac.uk');

INSERT INTO user_profile (user_id, bio, profile_picture)
VALUES (8, 'Professor of Biology at Brandeis University', E'\U0001F469\u200D\U0001F393'),
       (9, 'Professor of Neuroscience at University College London', E'\U0001F468\u200D\U0001F52C');

INSERT INTO user_settings (user_id, notification_sound, dark_mode)
VALUES (8, true, false),
       (9, true, false);

INSERT INTO friendship (user_id, friend_id)
VALUES ((SELECT id FROM users WHERE username = 'Eve_Marder'),
        (SELECT id FROM users WHERE username = 'Yoshua_Bengio')),
       ((SELECT id FROM users WHERE username = 'Michael_Häusser'),
        (SELECT id FROM users WHERE username = 'Yoshua_Bengio')),
       ((SELECT id FROM users WHERE username = 'Eve_Marder'),
        (SELECT id FROM users WHERE username = 'Michael_Häusser'));

INSERT INTO chat_member (chat_id, user_id)
VALUES ((SELECT id FROM chat WHERE name = 'Theoretical Computer Science and Algorithms'),
        (SELECT id FROM users WHERE username = 'Eve_Marder')),
       ((SELECT id FROM chat WHERE name = 'Theoretical Computer Science and Algorithms'),
        (SELECT id FROM users WHERE username = 'Michael_Häusser')),
       ((SELECT id FROM chat WHERE name = 'Theoretical Computer Science and Algorithms'),
        (SELECT id FROM users WHERE username = 'Yoshua_Bengio'));

INSERT INTO message (chat_id, user_id, text)
VALUES ((SELECT id FROM chat WHERE name = 'Theoretical Computer Science and Algorithms'),
        (SELECT id FROM users WHERE username = 'Eve_Marder'),
        'How can we convert neural spike data from sensors into a format that can be used in Java programming?');
INSERT INTO message (chat_id, user_id, text)
VALUES ((SELECT id FROM chat WHERE name = 'Theoretical Computer Science and Algorithms'),
        (SELECT id FROM users WHERE username = 'Yoshua_Bengio'),
        'We can use various data processing libraries such as PyTorch, TensorFlow, or Apache Spark. ' ||
        'We can also use programming languages such as Python to process data and create machine learning models.');
INSERT INTO message (chat_id, user_id, text)
VALUES ((SELECT id FROM chat WHERE name = 'Theoretical Computer Science and Algorithms'),
        (SELECT id FROM users WHERE username = 'Michael_Häusser'),
        'What machine learning algorithms can be used for analyzing neural spike data?');
INSERT INTO message (chat_id, user_id, text)
VALUES ((SELECT id FROM chat WHERE name = 'Theoretical Computer Science and Algorithms'),
        (SELECT id FROM users WHERE username = 'Yoshua_Bengio'),
        'Various machine learning algorithms can be used for analyzing neural spike data, ' ||
        'including neural networks, SVMs, decision trees, etc. The specific choice of algorithm depends ' ||
        'on the specific task and characteristics of the data you are working with.');
