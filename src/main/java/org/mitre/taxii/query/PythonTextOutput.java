/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mitre.taxii.query;

/**
 *
 * @author jasenj1
 */
public class PythonTextOutput {
    private static final String STD_INDENT = "  "; // A "Standard Indent" to use for to_text() methods
    
    public static String toText(Object obj) {
        return toText(obj,"");        
    }

    public static String toText(Object obj, String line_prepend) {
        String s = new String();
        if (null == line_prepend) {
            line_prepend = "";
        }
        
        if (obj instanceof DefaultQuery) {
            DefaultQuery self = (DefaultQuery)obj;
            // The opening line is rendered by taxii.messages.xml11's PythonOutputText.
            // s = super(DefaultQuery, self).to_text(line_prepend)
            s += line_prepend + String.format("  Targeting Expression ID: %s\n", self.getTargetingExpressionId());
            s += toText(self.getCriteria(), line_prepend);
            
            return s;
        }
        
        if (obj instanceof CriteriaType) {
            CriteriaType self = (CriteriaType)obj;
            s = line_prepend + "=== Criteria ===\n";
            s += line_prepend + String.format("  Operator: %s\n", self.getOperator());
            for (Object criteria : self.getCriteriasAndCriterions()) {
                s += toText(criteria, line_prepend + STD_INDENT);
            }
            return s;            
        }
        
        if (obj instanceof CriterionType) {
            CriterionType self = (CriterionType)obj;

            s = line_prepend + "=== Criterion ===\n";
            s += line_prepend + String.format("  Negate: %s\n", booleanString(self.isNegate()));
            s += line_prepend + String.format("  Target: %s\n", self.getTarget());
            s += toText(self.getTest(), line_prepend + STD_INDENT);
            return s;            
        }
        
        if (obj instanceof TestType) {
            TestType self = (TestType)obj;

            s = line_prepend + "=== Test ==\n";
            s += line_prepend + String.format("  Capability ID: %s\n", self.getCapabilityId());
            s += line_prepend + String.format("  Relationship: %s\n", self.getRelationship());            
            for (ParameterType parameter : self.getParameters()) {
                s += line_prepend + String.format("  Parameter: %s = %s\n", parameter.getName(), parameter.getValue());
            }
            return s;            
        }
        
        if (obj instanceof TargetingExpressionInfoType) {
            TargetingExpressionInfoType self = (TargetingExpressionInfoType)obj;
            
            s = line_prepend + "=== Targeting Expression Info ===\n";
            s += line_prepend + String.format("  Targeting Expression ID: %s\n", self.getTargetingExpressionId());
            for (String scope : self.getPreferredScopes()) {
                s += line_prepend + String.format("  Preferred Scope: %s\n",scope);
            }
            for (String scope : self.getAllowedScopes()) {
                s += line_prepend + String.format("  Allowed Scope: %s\n",scope);
            }
            return s;            
        }

        if (s.isEmpty()) {
            s = "Sorry, I do not know how to render a " + obj.getClass().getName();
        }
        return s;        
    }   
    
    /**
     * Turn a Boolean into a Python string representation.
     * 
     * @ return "None", "True", or "False".
     */
    private static String booleanString(Boolean value) {
        if (null == value) return "None";        
        return value ? "True" : "False";
    }
    
}
