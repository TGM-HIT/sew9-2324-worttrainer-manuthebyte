public interface PersistMethod {
    void persist(TrainerStatistics stats);
    TrainerStatistics load();
}
