/**
 * Interface for persisting and loading TrainerStatistics
 */
public interface PersistMethod {
    /**
     * Persists the given TrainerStatistics
     *
     * @param stats The TrainerStatistics to persist
     */
    void persist(TrainerStatistics stats);

    /**
     * Loads the TrainerStatistics
     *
     * @return The loaded TrainerStatistics
     */
    TrainerStatistics load();
}
