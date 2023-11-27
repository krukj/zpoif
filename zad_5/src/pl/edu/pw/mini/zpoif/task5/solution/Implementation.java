package pl.edu.pw.mini.zpoif.task5.solution;

import pl.edu.pw.mini.zpoif.task5.machine.MafiaMachine;
import pl.edu.pw.mini.zpoif.task5.people.MafiaWorker;
import pl.edu.pw.mini.zpoif.task5.people.special.ButtonMan;
import pl.edu.pw.mini.zpoif.task5.solution.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class Implementation extends MafiaMachine {
    protected String godFather = "pl.edu.pw.mini.zpoif.task5.people.special.GodFather";
    protected String accountant = "pl.edu.pw.mini.zpoif.task5.people.special.Accountant";
    protected String spy = "pl.edu.pw.mini.zpoif.task5.people.special.Spy";
    protected String recruiter = "pl.edu.pw.mini.zpoif.task5.people.special.Recruiter";
    protected String controller = "pl.edu.pw.mini.zpoif.task5.people.special.Controller";
    protected String buttonMan = "pl.edu.pw.mini.zpoif.task5.people.special.ButtonMan";
    protected String illegalSeller = "pl.edu.pw.mini.zpoif.task5.people.general.IllegalSeller";
    protected String legalSeller = "pl.edu.pw.mini.zpoif.task5.people.general.LegalSeller";

    protected Class<?>[] classes;

    {
        try {
            classes = new Class<?>[]{
                    Class.forName(godFather),
                    Class.forName(accountant),
                    Class.forName(spy),
                    Class.forName(buttonMan),
                    Class.forName(recruiter),
                    Class.forName(controller),
                    Class.forName(illegalSeller),
                    Class.forName(legalSeller)};
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Set<MafiaWorker> createImportantMafiaWorkers() throws Exception{
        Set<MafiaWorker> importantWorkers = new HashSet<>();
        for (Class<?> clazz : classes) {
            ImportantWorker annotation = clazz.getAnnotation(ImportantWorker.class);

            if (annotation != null && annotation.quantity() > 1) {
                for (int i = 0; i < annotation.quantity(); i++) {
                    importantWorkers.add((MafiaWorker) clazz.getDeclaredConstructor().newInstance());
                }
            }
        }
        return importantWorkers;
    }

    @Override
    protected MafiaWorker createPrimaryMafiaWorker() throws Exception {
            List<Class<?>> primaryWorkerClasses = new ArrayList<>();
            for (Class<?> clazz : classes) {
                Annotation annotation = clazz.getAnnotation(PrimaryMafiaWorker.class);
                if (annotation != null) {
                    primaryWorkerClasses.add(clazz);
                }
            }

            if (!primaryWorkerClasses.isEmpty()) {
                Class<?> selectedClass = primaryWorkerClasses.get(new Random().nextInt(primaryWorkerClasses.size()));
                return (MafiaWorker) selectedClass.getDeclaredConstructor().newInstance();

            }
            return null;
        }

    @Override
    protected MafiaWorker createPrioritizedPrimaryMafiaWorker() throws Exception{
        List<Class<?>> primaryWorkerClasses = new ArrayList<>();
        for (Class<?> clazz : classes) {
            PrimaryMafiaWorker annotation = clazz.getAnnotation(PrimaryMafiaWorker.class);
            if (annotation != null) {
                primaryWorkerClasses.add(clazz);
            }
        }

        if (!primaryWorkerClasses.isEmpty()) {
            primaryWorkerClasses.sort(Comparator
                    .<Class<?>, Integer>comparing(clazz -> clazz.getAnnotation(PrimaryMafiaWorker.class).priority())
                    .thenComparing(Class::hashCode));

            Class<?> selectedClass = primaryWorkerClasses.get(0);

            return (MafiaWorker) selectedClass.getDeclaredConstructor().newInstance();
            }
        return null;
        }

    @Override
    protected void encryptFields(Set<MafiaWorker> workers) throws Exception{
        for (MafiaWorker worker : workers) {
            Class<?> clazz = worker.getClass();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                if (field.getType() == String.class && field.isAnnotationPresent(FillIfEmptyIt.class)) {
                    field.setAccessible(true);
                    String value = (String) field.get(worker);
                    if (value == null || value.isEmpty()) {
                            // field.set(worker, RandomStringUtils().randomAlphaNumeric(10));
                            // nie moge zaimportowac randomStringUtils :((
                        }
                    }
                }
            }
        }


    @Override
    protected ButtonMan getKiller(String name, String surname) throws MafiaException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
            Constructor<ButtonMan> constructor = ButtonMan.class.getDeclaredConstructor(String.class, String.class);
            Parameter[] parameters = constructor.getParameters();

            for (Parameter parameter : parameters) {
                if (parameter.isAnnotationPresent(MafiaValidator.class) && parameter.getName().equals("name")) {
                    MafiaValidator validator = parameter.getAnnotation(MafiaValidator.class);
                    if (validator.notEmpty() && (name == null || name.isEmpty())) {
                        throw new MafiaException("ale jakies imie to trzeba wpisać");
                    }
                    if (name.length() > validator.maxLength()) {
                        throw new MafiaException("Za długie imie byku");
                    }
                }
            }

            return constructor.newInstance(name, surname);
    }

    @Override
    protected void init(MafiaWorker mafiaWorker) {
        Class<?> workerClass = mafiaWorker.getClass();

        Field[] fields = workerClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InitMe.class)) {
                field.setAccessible(true);
            }
        }

    }

    @Override
    protected void goButtonMan(Set<MafiaWorker> buttonMan) throws Exception{
        for (MafiaWorker mafiaWorker: buttonMan) {
            Method[] methods = mafiaWorker.getClass().getDeclaredMethods();
            for (Method method: methods) {
                method.setAccessible(true);
                if (method.isAnnotationPresent(DoIt.class)) {
                    DoIt annotation = method.getAnnotation(DoIt.class);
                    int times = annotation.times();
                    for (int i = 0; i < times; i++) {
                        method.invoke(buttonMan);
                    }
                }
            }
        }
    }

    @Override
    protected void retreat(ButtonMan buttonMan) {

    }
    private void checkMafiaValidatorAnnotation(Field field, String value) throws MafiaException {
        if (field.isAnnotationPresent(MafiaValidator.class)) {
            MafiaValidator annotation = field.getAnnotation(MafiaValidator.class);

            if (annotation.notEmpty() && (value == null || value.isEmpty())) {
                throw new MafiaException("Validation error: " + field.getName() + " cannot be empty");
            }

            if (value != null && value.length() > annotation.maxLength()) {
                throw new MafiaException("Validation error: " + field.getName() + " exceeds maximum length");
            }
        }
    }
}
