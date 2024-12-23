package by.epam.learn.vadimkominch.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ModifyAdvertismentCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //insert data from paragraph
//        Advertisment advertisment = new Advertisment();
//        advertisment.setAdvertismentId(Integer.parseInt(request.getParameter("ads_id")));
//        advertisment.setCategory(request.getParameter("Category"));
//        advertisment.setDate(new Date());
//        advertisment.setName(request.getParameter("Name"));
//        advertisment.setText(request.getParameter("Text"));
//        System.out.println(advertisment);
//        DAOInterface<Advertisment,String> daoInterface = new AdvertismentRepository();
//        daoInterface.update(request.getParameter("ads_id"),advertisment);
//        return "jsp/advertisment.jsp";
    }
}
