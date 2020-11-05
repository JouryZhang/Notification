package com.home.controller;

import com.home.dao.MessageDao;
import com.home.entity.MessData;
import com.home.entity.Message;
import com.home.entity.MessagePack;
import com.home.security.utils.ResponseResult;
import com.home.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**接收报文和查询报文的接口*/
@Controller
public class MessageController {
    private Logger logger =  LoggerFactory.getLogger(MessageController.class);
    @Autowired
    private MessageDao messageDao;


    @RequestMapping("/pubsub/push")
    public ResponseEntity getMessage(Map<String,Object> model, Principal principal, @RequestBody MessData messData) throws IOException, ParseException {
        MessagePack pack = messData.getMessage();
        Message m = new Message();

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes = decoder.decodeBuffer(pack.getData());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        m.setPublishtime(format.parse( pack.getPublishTime().replace("Z", " UTC")));
        m.setMessageid(pack.getMessageId());
        m.setData(new String(bytes));
        messageDao.insert(m);
        logger.warn("******************【接收一条数据成功！】******************");
        return ResponseEntity.ok().body(ResponseResult.ok("成功接收"));
    }
    /**
     * 系统入口，进入展示页面
     */
    @RequestMapping("/main/{page}")
    public ModelAndView main(Map<String,Object> model,Principal principal, @PathVariable(value = "page",required = false) int page){
        if (!StringUtil.isNullOrEmpty(page) && page > 0) {
            page = page;
        } else {
            page = 1;
        }
        model.put("page", page);
        model.put("messages",messageDao.selectByPage((page - 1) * 10, 10));
        logger.warn("||||_____reload______||||");
        return new ModelAndView("index", model);
    }
    /**
     * 系统入口，进入展示页面
     */
    @RequestMapping("/")
    public ModelAndView index(Map<String,Object> model,Principal principal){
        model.put("page", 1);
        model.put("messages",messageDao.selectByPage((1 - 1) * 10, 10));
        logger.warn("||||_____reload______||||");
        return new ModelAndView("index", model);
    }


}
