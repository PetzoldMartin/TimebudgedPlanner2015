package de.fhzwickau.tbp.automat;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_2_8210263_1433001027643_848303_3640) 
 */
import javax.interceptor.InvocationContext;
import javax.interceptor.AroundInvoke;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.fhzwickau.tbp.material.PlanningData;
import de.fhzwickau.tbp.material.Project;
import de.fhzwickau.tbp.material.Task;
import de.fhzwickau.tbp.tools.dto.NewBooking;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class BookingInterceptor {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Method stub for further implementation.
	 */
	
	@AroundInvoke
	public Object aroundInvoke(InvocationContext ctx) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_2_8210263_1433001489477_281391_3717) ENABLED START */
		try {
			if (ctx.getParameters()[0] instanceof NewBooking) {
				NewBooking newBooking = (NewBooking) ctx.getParameters()[0];
				Task t = entityManager.find(Task.class, newBooking.getTaskId());
				Project p = t.getMilestone().getProject();
				PlanningData latestPlanningData = null;
				for (PlanningData d : p.getPlanningData()) {
					if (latestPlanningData == null || latestPlanningData.getTstamp().getTime() < d.getTstamp().getTime()) {
						latestPlanningData = d;
					}
				}
				float budgetLimit = latestPlanningData.getTimeBudgetPlan();
				float currentTimeBudgetUsed = p.getTimeBudgetAct();
				if (currentTimeBudgetUsed + ((newBooking.getEnd().getTime() - newBooking.getStart().getTime()) / 1000 / 60 / 60) > budgetLimit)
					System.out.println("Time Budget exceeded");
				else
					System.out.println("Time Budget okay");
			}
			
			try {
				ctx.proceed();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return null;
		} finally {
		}
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_2_8210263_1433001027643_848303_3640) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
