package es.ulpgc.miguel.sprint3.app;

import java.util.List;

public interface RepositoryContract {
  void add();
  void plus(int id);

  List<Counter> list();

  int clicks();
}
