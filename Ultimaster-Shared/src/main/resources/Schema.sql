CREATE
    TABLE
        "user"(
            id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
            name TEXT NOT NULL,
            mail TEXT NOT NULL,
            password TEXT NOT NULL,
            admin BOOLEAN NOT NULL DEFAULT FALSE
        );

CREATE
    TABLE
        printer(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            host TEXT NOT NULL,
            printer_id TEXT,
            printer_key TEXT,
            queue_active BOOLEAN NOT NULL DEFAULT false
        );
        
CREATE
    TABLE
        printjob(
            id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
            "order" INTEGER NOT NULL,
            active BOOLEAN NOT NULL DEFAULT TRUE,
            name TEXT NOT NULL,
            file BLOB NOT NULL,
            filename TEXT NOT NULL,
            user_id INTEGER NOT NULL REFERENCES user(id)
        );