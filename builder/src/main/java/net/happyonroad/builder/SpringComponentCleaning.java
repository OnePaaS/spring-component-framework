/**
 * @author XiongJie, Date: 13-12-2
 */
package net.happyonroad.builder;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.io.IOException;

/** The spring component cleaner*/
@SuppressWarnings("UnusedDeclaration")
@Mojo(name = "clean", inheritByDefault = false, defaultPhase = LifecyclePhase.CLEAN)
public class SpringComponentCleaning extends AbstractMojo {
    @Parameter
    private File output;

    public void execute() throws MojoExecutionException {
        getLog().info("Hello, I'm cleaning for: " + output.getPath());
        try {
            FileUtils.deleteDirectory(output);
        } catch (IOException e) {
            getLog().error("Can't clean " + output.getPath() + ", because of:" + e.getMessage());
            throw new MojoExecutionException("Can't clean " + output.getPath(), e);
        }
    }
}
