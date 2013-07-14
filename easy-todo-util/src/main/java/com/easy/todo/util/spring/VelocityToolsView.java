package com.easy.todo.util.spring;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.apache.velocity.tools.ToolContext;
import org.apache.velocity.tools.config.XmlFactoryConfiguration;
import org.apache.velocity.tools.view.ViewToolManager;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * User: zhangtan
 * Date: 13-6-6
 * Time: 下午1:49
 */
public class VelocityToolsView extends VelocityLayoutView {

    private ViewToolManager toolManager;

 	@Override
 	protected Context createVelocityContext (Map<String, Object> model,
 	                                         HttpServletRequest request,
 	                                         HttpServletResponse response) {
 		ToolContext toolContext = toolManager.createContext(request, response);
 		VelocityContext context = new VelocityContext(toolContext);
        for (Map.Entry o : model.entrySet() ){
            if (o != null){
                context.put(o.getKey().toString(),o.getValue());
            }
        }

 		return context;
 	}

 	@Override
 	public void afterPropertiesSet() throws Exception {
 		super.afterPropertiesSet();
 		XmlFactoryConfiguration config = new XmlFactoryConfiguration();
         config.read(Thread.currentThread().getContextClassLoader().getResource(getToolboxConfigLocation()));
// 		config.read(getServletContext().getResourceAsStream(getToolboxConfigLocation()));  此方法glashfish下面找不到文件
 		boolean autoConfigure = false;
 		boolean includeDefaults = false;
 		toolManager = new ViewToolManager(getServletContext(), autoConfigure, includeDefaults);
 		toolManager.configure(config);
 		toolManager.setVelocityEngine(getVelocityEngine());
 	}
}