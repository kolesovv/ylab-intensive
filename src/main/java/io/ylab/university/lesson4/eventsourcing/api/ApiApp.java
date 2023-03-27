package io.ylab.university.lesson4.eventsourcing.api;

import com.rabbitmq.client.ConnectionFactory;
import io.ylab.university.lesson4.RabbitMQUtil;

public class ApiApp {

  public static void main(String[] args) throws Exception {

    ConnectionFactory connectionFactory = initMQ();
    // Тут пишем создание PersonApi, запуск и демонстрацию работы
  }

  private static ConnectionFactory initMQ() throws Exception {

    return RabbitMQUtil.buildConnectionFactory();
  }
}
