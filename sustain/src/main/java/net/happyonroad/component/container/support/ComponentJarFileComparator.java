/**
 * Developer: Kadvin Date: 14-4-21 下午8:42
 */
package net.happyonroad.component.container.support;

import net.happyonroad.component.core.Component;

import java.io.File;
import java.util.Comparator;

/**
 * Component jar file comparator
 */
class ComponentJarFileComparator implements Comparator<File> {
    DefaultComponentRepository repository;

    ComponentJarFileComparator(DefaultComponentRepository repository) {
        this.repository = repository;
    }

    @Override
    public int compare(File jar1, File jar2) {
        Component comp1;
        Component comp2;
        try {
            comp1 = repository.resolveComponent(jar1.getName());
        } catch (Exception e) {
            throw new RuntimeException("Can't resolve " + jar1.getPath(), e );
        }
        try {
            comp2 = repository.resolveComponent(jar2.getName());
        } catch (Exception e) {
            throw new RuntimeException("Can't resolve " + jar2.getPath(), e );
        }

        int compare = repository.compare(comp1, comp2);
        //System.out.printf("\t%s <=> %s = %d\n", comp1.getFileName(), comp2.getFileName(), compare);
        return compare;
    }
}
