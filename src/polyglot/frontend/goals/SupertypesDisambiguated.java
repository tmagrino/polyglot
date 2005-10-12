/*
 * Disambiguated.java
 * 
 * Author: nystrom
 * Creation date: Oct 11, 2005
 */
package polyglot.frontend.goals;

import java.util.*;

import polyglot.ast.NodeFactory;
import polyglot.frontend.Job;
import polyglot.frontend.Scheduler;
import polyglot.types.TypeSystem;
import polyglot.visit.AmbiguityRemover;

public class SupertypesDisambiguated extends VisitorGoal {
    public static Goal create(Scheduler scheduler, Job job, TypeSystem ts, NodeFactory nf) {
        return scheduler.internGoal(new SupertypesDisambiguated(job, ts, nf));
    }

    protected SupertypesDisambiguated(Job job, TypeSystem ts, NodeFactory nf) {
        super(job, new AmbiguityRemover(job, ts, nf, false, false));
    }

    public Collection prerequisiteGoals(Scheduler scheduler) {
        List l = new ArrayList();
        l.addAll(super.prerequisiteGoals(scheduler));
        l.add(scheduler.ImportTableInitialized(job));
        return l;
    }
}