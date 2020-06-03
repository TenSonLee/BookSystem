package com.jl.graduatedesign.algorithm;

import com.jl.graduatedesign.dao.*;
import com.jl.graduatedesign.entity.Evaluation;
import com.jl.graduatedesign.entity.ReadHistory;
import com.jl.graduatedesign.entity.Recommend;
import com.jl.graduatedesign.entity.User;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.similarity.precompute.example.GroupLensDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class PersonalRecommend {
    private ReadHistoryDao readHistoryDao;

    private EvaluationDao evaluationDao;

    private UserDao userDao;

    private PersonalRecommendDao personalRecommendDao;

    @Autowired
    public void setReadHistoryDao(ReadHistoryDao readHistoryDao) {
        this.readHistoryDao = readHistoryDao;
    }

    @Autowired
    public void setEvaluationDao(EvaluationDao evaluationDao) {
        this.evaluationDao = evaluationDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPersonalRecommendDao(PersonalRecommendDao personalRecommendDao) {
        this.personalRecommendDao = personalRecommendDao;
    }

    public void buildDataFileFromDatabase() throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("rating.csv")));
        List<User> users = userDao.getAllUserByType(1);
        int score = 3;
        for (User user:
             users) {
            List<ReadHistory> userAllHistory = readHistoryDao.getUserAllHistory(user.getUserId());
            for (ReadHistory history:
                 userAllHistory) {
                Evaluation evaluation = evaluationDao.getEvaluationByUserAndBookId(user.getUserId(), history.getBookId());
                if(evaluation != null){
                    score = evaluation.getScore();
                }else {
                    score = 3;
                }
                String str = user.getUserId()+","+history.getBookId()+","+score;
                out.write(str);
                out.newLine();
            }
        }
        out.flush();
        out.close();
    }

    public void userCf(Long userId,Integer num) throws Exception{
        File file = new File("rating.csv");
        DataModel dataModel = new FileDataModel(file);
        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
        UserNeighborhood userNeighborhood = new NearestNUserNeighborhood(100, similarity, dataModel);
        Recommender recommender = new GenericUserBasedRecommender(dataModel, userNeighborhood, similarity);
        List<RecommendedItem> recommendedItemList = recommender.recommend(userId, num);

        personalRecommendDao.clearByUserId(userId);
        for (RecommendedItem recommendedItem : recommendedItemList) {
            personalRecommendDao.insertPersonalRecommendInfo(userId,recommendedItem.getItemID(), String.valueOf(recommendedItem.getValue()));
            System.out.println(recommendedItem);
        }
    }
}
