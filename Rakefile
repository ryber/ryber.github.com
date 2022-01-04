# how to run rake tasks:
#
# download the latest jruby binary distribution, i.e. http://jruby.org.s3.amazonaws.com/downloads/1.7.0.preview1/jruby-bin-1.7.0.preview1.zip
# extract that zip to some place like c:\bench
# add the bin directory to your path...C:\bench\jruby-1.7.0.preview1\bin
# open a command prompt to the axiom root
#
# all available tasks can be displayed with rake -T
#
# run a task as rake [task_name] i.e. rake verify, rake routes
require 'fileutils'

desc 'clean'
task :clean do
  system('mvn clean')
end

desc 'unit tests'
task :compile do
    system('mvn package')
    system('java -cp "ryber.github.com-1:Generator.jar" CheckSum --algorithm SHA-1 hello.txt)
end

def run(command)
  raise "Failed to execute '#{command}'" if !system(command)
end

desc 'verify'
task :verify do
  run("mvn clean verify -U")
end

desc 'purge test results and logs'
task :purge do
	FileUtils.rm_r File.join(File.dirname(__FILE__),'toggles-core/src/test/fitnesse/FitNesseRoot/files/testResults/')
end

desc 'release'
task :release do
	run("mvn release:prepare")
	run("mvn release:perform -DskipTests")
end



