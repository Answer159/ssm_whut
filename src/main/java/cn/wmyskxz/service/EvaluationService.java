package cn.wmyskxz.service;
import cn.wmyskxz.pojo.Evaluation;
import java.util.List;
public interface EvaluationService {
    int add(Evaluation evaluation);

    boolean delete(int id);

    int update(Evaluation evaluation);

    Evaluation get(int id);

    List<Evaluation> listByClass(int class_id);
}
