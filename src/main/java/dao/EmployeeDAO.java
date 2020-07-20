package dao;

import beans.employee.Employee;
import dao.interfaces.EmployeeDaoInterface;
import hibernate.entity.employee.EmployeeEntity;
import hibernate.entity.information.EmployeeEducation;
import hibernate.entity.information.EmployeeFiles;
import hibernate.entity.information.EmployeeSocialMedia;
import hibernate.entity.other.JobTypes;
import hibernate.entity.other.Qualification;
import hibernate.entity.other.Skills;
import loginaction.model.loginModel.LoginModel;
import loginaction.model.responselogin.UserLoginResponse;
import models.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDAO implements EmployeeDaoInterface<EmployeeEntity, Integer> {

    private static SessionFactory sessionFactory;
    private static Session session;


    public EmployeeDAO() {
    }

    public void openSession() {
         session = getSessionFactory().getCurrentSession();
    }

    public void closeSessionAndFactory() {
        session.close();
        sessionFactory.close();
    }


    private static SessionFactory getSessionFactory() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(EmployeeSocialMedia.class)
                .addAnnotatedClass(Skills.class)
                .addAnnotatedClass(JobTypes.class)
                .addAnnotatedClass(Qualification.class)
                .addAnnotatedClass(EmployeeEducation.class)
                .addAnnotatedClass(EmployeeFiles.class)
                .buildSessionFactory();
        return sessionFactory;
    }



    @Override
    public EmployeeEntity findByID(Integer id) {
        session.beginTransaction();
        EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, id);
        return employeeEntity;
    }

    @Override
    public EmployeeEntity findByIDAndSocialMedia(Integer id) {
        session.beginTransaction();
        EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, id);
        employeeEntity.getEmployeeSocialMediaList();
        return employeeEntity;
    }

    @Override
    public void update(EmployeeEntity entity) {
        session.beginTransaction();
        session.update(entity);
    }

    @Override
    public void delete(EmployeeEntity entity) {
        session.beginTransaction();
        session.delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeEntity> findAll() {
        session.beginTransaction();
        List<EmployeeEntity> employeeEntityList = (List<EmployeeEntity>) session.createQuery("from EmployeeEntity ").getResultList();
        return employeeEntityList;
    }

    @Override
    public List<EmployeeEntity> findAllWithSocialMedia() {
        session.beginTransaction();
        List<EmployeeEntity> employeeEntityList = (List<EmployeeEntity>) session.createQuery("from EmployeeEntity").getResultList();
        for (EmployeeEntity entity : employeeEntityList) {
            entity.getEmployeeSocialMediaList();
        }
        return employeeEntityList;

    }

    @Override
    public void deleteAll() {
        List<EmployeeEntity> entityList = findAll();
        session.beginTransaction();
        for (EmployeeEntity entity : entityList) {
            session.delete(entity);
        }
    }

    public static UserLoginResponse checkEmployeeInput(LoginModel loginModel) {

        return new UserLoginResponse.UserLoginResponseBuilder()
                .id(1)
                .firstName("vazken")
                .role(new Role("EMPLOYEE_ROLE"))
                .build();
    }

    public Employee getEmployeeData(int id) {
        // select query where is from userobject = ?

        if (id == 1)
            return new Employee.EmployeeBuilder()
                    .firstName("vazken")
                    .lastName("abdulian")
                    .id(1)
                    .role(new Role("EMPLOYEE_ROLE"))
                    .date("1998-09-13")
                    .mail("vazken99@gmail.com")
                    .build();
        return null;

    }
}
/*

    public static UserLoginResponse checkEmployeeInput(LoginModel loginModel) {

        return   new UserLoginResponse.UserLoginResponseBuilder()
                .id(1)
                .firstName("vazken")
                .role(new Role("EMPLOYEE_ROLE"))
                .build();
    }


    public Employee getEmployeeData(int id) {
        // select query where is from userobject = ?

        if(id == 1)
            return new Employee.EmployeeBuilder()
                    .firstName("vazken")
                    .lastName("abdulian")
                    .id(1)
                    .role(new Role("EMPLOYEE_ROLE"))
                    .date("1998-09-13")
                    .mail("vazken99@gmail.com")
                    .build();
        return null;

    }

    public static void getAllEmployeeInfo(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(EmployeeSocialMedia.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{


            session.beginTransaction();

            System.out.println("getting info");
            List<EmployeeEntity> list = session.createQuery("FROM  EmployeeEntity").getResultList();

            System.out.println("done");
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
                System.out.println(list.get(i).getEmployeeSocialMediaList());
            }
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }

    }

    */
/*
        one to one bi direction
        getting user social media by user information
        lazy
     *//*

    public static void getAllEmployeeWithSocialMedia(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(EmployeeSocialMedia.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{


            session.beginTransaction();

          */
/*
            lazy mode problem solved
          Query<EmployeeEntity> query = session.createQuery("select i from EmployeeEntity i join fetch i.employeeSocialMediaList where i.id =:userID");
            query.setParameter("userID",1);
            EmployeeEntity employeeEntity = query.getSingleResult();
            System.out.println(employeeEntity);
            System.out.println(employeeEntity.getEmployeeSocialMediaList());*//*

            //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
            EmployeeEntity employee = session.get(EmployeeEntity.class,1);

            System.out.println("getting social media");
            System.out.println("employe = "+ employee);

            System.out.println("courses = "+employee.getEmployeeSocialMediaList());

            session.getTransaction().commit();
            System.out.println("done");

        }catch(Exception e){
            // ex id obj return null and there will be leak in connection pool
            //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
            e.printStackTrace();
        }
        finally {
            // connection pool clean and no longer leaks
            session.close();
            factory.close();
        }

    }

    public static void deleteEmployeeWithSocialMedia(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(EmployeeSocialMedia.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{


            session.beginTransaction();
            //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
            EmployeeEntity employee = session.get(EmployeeEntity.class,28);
            session.delete(employee);

            session.getTransaction().commit();
            System.out.println("done");

        }catch(Exception e){
            // ex id obj return null and there will be leak in connection pool
            //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
            e.printStackTrace();
        }
        finally {
            // connection pool clean and no longer leaks
            session.close();
            factory.close();
        }

    }


    public static void deleteEmployeeSocialMedia() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(EmployeeSocialMedia.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {


            session.beginTransaction();
            //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
            EmployeeEntity employee = session.get(EmployeeEntity.class, 17);
            // EmployeeSocialMedia employeeSocialMedia =  employee.getEmployeeSocialMedia();
            // System.out.println(employeeSocialMedia);
            //  session.delete(employeeSocialMedia);

            session.getTransaction().commit();
            System.out.println("done");

        } catch (Exception e) {
            // ex id obj return null and there will be leak in connection pool
            //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
            e.printStackTrace();
        } finally {
            // connection pool clean and no longer leaks
            session.close();
            factory.close();
        }
    }
        public static void addEmployee(){
            SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(EmployeeEntity.class)
                    .addAnnotatedClass(EmployeeSocialMedia.class)
                    .buildSessionFactory();

            Session session = factory.getCurrentSession();

            try{


                session.beginTransaction();
                EmployeeEntity employee = new EmployeeEntity();
                employee.setEmployeeName("lusin");
                employee.setEmployeeSurname("kurkjian");
                long millis=System.currentTimeMillis();
                java.sql.Date date=new java.sql.Date(millis);
                employee.setEmployeeBirthDate(date);
                employee.setEmployeeBio("hey");
                employee.setEmployeePassword("12335132");
                employee.setEmployeeProfile("null");
                employee.setEmployeePhone("077295655");
                employee.setEmployeeGender("female");
                employee.setEmployeeResume("null");
                employee.setEmployeeRole("employee");
                employee.setEmployeeMail("lusin@gmail.com");
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                employee.setEmployeeCreationDate(timestamp);


                session.save(employee);


                session.getTransaction().commit();
                System.out.println("done");

            }catch(Exception e){
                // ex id obj return null and there will be leak in connection pool
                //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
                e.printStackTrace();
            }
            finally {
                // connection pool clean and no longer leaks
                session.close();
                factory.close();
            }
        }






    public static void addEmployeeWithSocialMediaLinks(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(EmployeeSocialMedia.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{


            session.beginTransaction();
            EmployeeEntity employee = new EmployeeEntity();
            employee.setEmployeeName("lusin2");
            employee.setEmployeeSurname("kurkjian");
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            employee.setEmployeeBirthDate(date);
            employee.setEmployeeBio("hey");
            employee.setEmployeePassword("12335132");
            employee.setEmployeeProfile("null");
            employee.setEmployeePhone("077295655");
            employee.setEmployeeGender("female");
            employee.setEmployeeResume("null");
            employee.setEmployeeRole("employee");
            employee.setEmployeeMail("lusin@gmail.com");
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            employee.setEmployeeCreationDate(timestamp);

            EmployeeSocialMedia employeeSocialMedia = new EmployeeSocialMedia();
            employeeSocialMedia.setSocialMediaName("twiter");
            employeeSocialMedia.setSocialMediaLink("blabla");

            EmployeeSocialMedia employeeSocialMedia2 = new EmployeeSocialMedia();
            employeeSocialMedia2.setSocialMediaName("facebook");
            employeeSocialMedia2.setSocialMediaLink("blabla");

            employee.add(employeeSocialMedia);
            employee.add(employeeSocialMedia2);

            System.out.println(employee);
            System.out.println(employee.getEmployeeSocialMediaList());

            session.save(employee);



            session.getTransaction().commit();
            System.out.println("done");

        }catch(Exception e){
            // ex id obj return null and there will be leak in connection pool
            //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
            e.printStackTrace();
        }
        finally {
            // connection pool clean and no longer leaks
            session.close();
            factory.close();
        }
    }


    public static void addToEmployeeSocialMediaLinks(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(EmployeeSocialMedia.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{


            session.beginTransaction();
            EmployeeEntity employee = session.get(EmployeeEntity.class,1);


            EmployeeSocialMedia employeeSocialMedia = new EmployeeSocialMedia();
            employeeSocialMedia.setSocialMediaName("linkdin");
            employeeSocialMedia.setSocialMediaLink("blabla");

            EmployeeSocialMedia employeeSocialMedia2 = new EmployeeSocialMedia();
            employeeSocialMedia2.setSocialMediaName("udemy");
            employeeSocialMedia2.setSocialMediaLink("blabla");

            employee.add(employeeSocialMedia);
            employee.add(employeeSocialMedia2);


       
            session.save(employeeSocialMedia);
            session.save(employeeSocialMedia2);



            session.getTransaction().commit();
            System.out.println("done");

        }catch(Exception e){
            // ex id obj return null and there will be leak in connection pool
            //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
            e.printStackTrace();
        }
        finally {
            // connection pool clean and no longer leaks
            session.close();
            factory.close();
        }
    }


    public static void deleteEmployeeOnlySocialMedia() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeEntity.class)
                .addAnnotatedClass(EmployeeSocialMedia.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {


            session.beginTransaction();
            //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
            EmployeeSocialMedia employeeSocialMedia = session.get(EmployeeSocialMedia.class, 9);
            // EmployeeSocialMedia employeeSocialMedia =  employee.getEmployeeSocialMedia();
            // System.out.println(employeeSocialMedia);
              session.delete(employeeSocialMedia);

            session.getTransaction().commit();
            System.out.println("done");

        } catch (Exception e) {
            // ex id obj return null and there will be leak in connection pool
            //EmployeeEntity employee = session.get(EmployeeEntity.class,122);
            e.printStackTrace();
        } finally {
            // connection pool clean and no longer leaks
            session.close();
            factory.close();
        }
    }



    public static Date parseDate(String date) {
        try {
            return (Date) new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
    }

*/
