/*
    MySQL
    БД -> табл

    json -> csv
    csv -> json

    csv -> БД
    БД -> csv

    objectmapper
    коллекции

    Работа с файлами

    1) csv

    try {
        FileWriter fw = new FileWriter("test.txt", false);
        fw.write (user.toCSV());
        fw.close();
    } catch(IOException err) {
        System.err...
    }

    //
    некоторые файлы поддерживают автозакрытие
    try(FileWriter fw = new FileWriter("test.txt", false)){
    }
    //
    Стек текущего потока ?
    //

    interface CSV {
        String toCSV();
        void fromCSV(String str);
    }

    //
        20% дела - 80% успеха, 80% дела - 20% успеха.
    //


    class User implement CSV, JSON {
        public void fromCSV (String str) {
            String[] mass = str.split(';');
            this.id = Integer.valueOf(mass[0]);
                .fio =
                .phone =
        }
        pulic String toCSV() {
            return String.valueOf(this.id + ";" + ...);
        }
    }


    2) Jackson

    build.gradle
        apply plagin: "java"
        apply plagin: "application"
        mainClassName = "ru.eltex.App"
        dependencies {
            compile ...     // mvnrepository.org // найти jackson
        }

    $ gradle run

    objectmapper mapper = new objectmapper();
    // В json
    String str = mapper.writeValutAsString(user1);
    // Обратно
    List<User>user2 = mapper.readValue(str; User.class);

    $ gradle run

    // vertex ?????

    TCP             UDP

*/
