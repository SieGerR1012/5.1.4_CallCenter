void main() throws InterruptedException {
    CallCenter callCenter = new CallCenter();

    ATS ats = new ATS(callCenter);

    Specialist s1 = new Specialist("Специалист 1", callCenter);
    Specialist s2 = new Specialist("Специалист 2", callCenter);
    Specialist s3 = new Specialist("Специалист 3", callCenter);

    System.out.println("Запуск системы техподдержки...\n");

    ats.start();
    s1.start();
    s2.start();
    s3.start();

    ats.join();
    s1.join();
    s2.join();
    s3.join();

    System.out.println("\nВсе звонки обработаны. Система завершена.");
}
