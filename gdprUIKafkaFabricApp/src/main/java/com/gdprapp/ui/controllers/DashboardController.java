package com.gdprapp.ui.controllers;


import com.gdprapp.ui.bo.requests.ShowProduct;
import com.gdprapp.ui.bo.ui.SearchBo;
import com.gdprapp.ui.bo.ui.TransactionBO;
import com.gdprapp.ui.orm.model.BatchItem;
import com.gdprapp.ui.orm.repository.BatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DashboardController {


    @Autowired
    BatchRepository batchRepository;

    @RequestMapping(value={"/dashboard"}, method = RequestMethod.GET)
    public ModelAndView showDashboard( ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @RequestMapping(value={"/mydata"}, method = RequestMethod.GET)
    public ModelAndView showMyData( ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mydata");
        return modelAndView;
    }

    @RequestMapping(value={"/journey"}, method = RequestMethod.GET)
    public ModelAndView journey( ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("journey");
        model.addAttribute("showInput",true);

        return modelAndView;
    }

    @RequestMapping(value={"/journey/show"}, method = RequestMethod.POST)
    public ModelAndView journeyShow(ShowProduct product, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("journey");
        model.addAttribute("showInput",false);

        return modelAndView;
    }

    @RequestMapping(value={"/addBatch"}, method = RequestMethod.GET)
    public ModelAndView addBatch(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addBatch");
        model.addAttribute("showInput",false);

        Instant instant = Instant.now();
        long timeStampSeconds = instant.getEpochSecond();

        model.addAttribute("batchId",timeStampSeconds);

        return modelAndView;
    }

    @RequestMapping(value={"/addBatch"}, method = RequestMethod.POST)
    public ModelAndView addBatchPost(BatchItem batchItem, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("batchList");
        model.addAttribute("showInput",false);

        Instant instant = Instant.now();
        long timeStampSeconds = instant.getEpochSecond();

        model.addAttribute("batchId",timeStampSeconds);

        batchRepository.save(batchItem);

        model.addAttribute("batches",batchRepository.findAll());

        return modelAndView;
    }

    public List<TransactionBO> generaateTransactionList(){

        List<TransactionBO> resultList = new ArrayList<>();

        return resultList;
    }

    @RequestMapping(value={"/journeyM"}, method = RequestMethod.GET)
    public ModelAndView journeyM( ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("journeyM");
        model.addAttribute("showInput",true);

        return modelAndView;
    }

    @RequestMapping(value={"/batchList"}, method = RequestMethod.GET)
    public ModelAndView batchList( ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("batchList");
        model.addAttribute("batches",batchRepository.findAll());


        return modelAndView;
    }


    @RequestMapping(value={"/searchBatch"}, method = RequestMethod.GET)
    public ModelAndView searchBatch( ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchBatch");


        return modelAndView;
    }

    @RequestMapping(value={"/searchBatch"}, method = RequestMethod.POST)
    public ModelAndView searchBatchName(SearchBo bo, ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchBatch");

        BatchItem item = batchRepository.findByDrugNameContaining(bo.getDrugName());

        ArrayList<BatchItem> list = new ArrayList<BatchItem>();

        if (item != null){

            list.add(item);

            model.addAttribute("batches",list);
        }else {

        }



        return modelAndView;
    }

}
