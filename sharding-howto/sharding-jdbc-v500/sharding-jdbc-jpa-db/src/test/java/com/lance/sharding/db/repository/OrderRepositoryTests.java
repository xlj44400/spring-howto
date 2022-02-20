package com.lance.sharding.db.repository;

import com.lance.sharding.db.entity.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * order entity
 *
 * @author lance
 * @date 2022/2/19 11:56
 */
@Slf4j
@SpringBootTest
class OrderRepositoryTests {
  @Autowired
  private OrderRepository orderRepository;

  @Test
    //@Disabled
  void save() {
    ThreadLocalRandom random = ThreadLocalRandom.current();

    IntStream.range(20, 41).forEach(i -> {
      OrderEntity order = new OrderEntity();
      order.setAddressId(i);
      order.setUserId(Math.abs(random.nextInt()));
      order.setCreator("user.0" + i);
      order.setUpdater(order.getCreator());
      orderRepository.save(order);
    });
  }
}
