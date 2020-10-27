package com.huatec.edu.mobileshop.db;

import android.content.Context;

import com.huatec.edu.mobileshop.gen.CategoryDao;
import com.huatec.edu.mobileshop.gen.TestDao;
import com.huatec.edu.mobileshop.gen.TodayDao;
import com.huatec.edu.mobileshop.gen.UserDao;
import com.huatec.edu.mobileshop.gen.WeatherEntityDao;

public class DbUtils {
    private Context context;
    private CategoryDao categoryDao;
    private UserDao userDao;
    private TestDao testDao;
    private TodayDao todayDao;
    private WeatherEntityDao weatherEntityDao;

    public DbUtils(Context context) {
        this.context = context;
        categoryDao = GreenDaoManager.getInstance().getDaoSession().getCategoryDao();
        userDao = GreenDaoManager.getInstance().getDaoSession().getUserDao();
        testDao = GreenDaoManager.getInstance().getDaoSession().getTestDao();
        todayDao =  GreenDaoManager.getInstance().getDaoSession().getTodayDao();
        weatherEntityDao = GreenDaoManager.getInstance().getDaoSession().getWeatherEntityDao();
    }
    public void add(WeatherEntity weatherEntity) {
        weatherEntityDao.insert(weatherEntity);
    }

    //    public void add(Test test) {
//        testDao.insert(test);
//        }
//
//    }
//    public void add(Today today) {
//        todayDao.insert(today);
//    }
    }

//    public void add() {
//        User user;
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//        String now = (df.format(new Date()));// new Date()为获取当前系统时间
//        for (int i = 0; i < 5; i++) {
//            int count = i + 1;
//            user = new User(null, "郑" + count + "博", "17091231027", "ruanjian1710@qq.com", "1999-06-25", now, now, 0);
//            userDao.insert(user);
//        }
//    }
//        public List<User> selectAllData(){
//        List<User> uesrs = userDao.loadAll();
//        for (User c:uesrs
//             ) {
//            Log.i("=========", "=========>>>" + c.toString());
//        }
//        return uesrs;
//    }

//    public void add() {
//        Category category;
//        for (int i = 0; i < 10; i++) {
//            int count = i + 1;
//            category = new Category(null, "增加商品" + i, 1, "1", count, 12, 112, 1, "13131");
//            categoryDao.insert(category);
//        }
//    }
//    public List<Category> selectAllData(){
//        List<Category> categories = categoryDao.loadAll();
//        for (Category c:categories
//             ) {
//            Log.i("=========", "=========>>>" + c.getName());
//        }
//        return categories;
//    }
//
//    public Category selectById(long id) {
//        return categoryDao.load(id);
//    }
//    /**
//     * 根据行号查数据
//     */
//    public Category selectByRowId(long id) {
//        return categoryDao.loadByRowId(id);
//    }
//
//    public void deleteDataById(long id) {
//        categoryDao.deleteByKey(id);
//    }
//
//    public void updateById(Category category) {
//        categoryDao.update(category);
//    }

