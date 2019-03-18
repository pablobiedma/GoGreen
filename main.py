from weasyprint import HTML, CSS
import os
import sys
import datetime

print(str(sys.argv))

if(len(sys.argv) < 2):
    print("Missing argument url!")
    sys.exit(1)

os.system("zsh -c 'git clone "+sys.argv[1]+" project'")

os.system("zsh -c 'chmod +x ./project/gradlew;cd ./project; ./gradlew check jacocoRootReport'")

convert = list()

for root, dirs, files in os.walk("./project"):
    if "test" in str(root) or "resources" in str(root) or "tmp" in str(root):
        continue
    for file in files:
        if file.endswith(".html") and ("jacoco" not in str(root) or ("nl" not in str(root) and "index" in str(file))):
            print(os.path.abspath(os.path.join(root, file)))
            convert.append(os.path.abspath(os.path.join(root, file)))

print(str(convert))

prefix = str(datetime.date.today()).replace('-', '')

for file in convert:
    if "checkstyle" in file:
        id = "checkstyle"
    else:
        id = "jacoco"
    if "library" in file:
        part = "_library"
    elif "client" in file:
        part = "_client"
    elif "server" in file:
        part = "_server"
    else:
        part = ""

    style = CSS(string='''
    body, td {
  font-family:sans-serif;
  font-size:10pt;
  background-color: white;
}
''')
    base = os.path.join("project","doc","reports", id, part)
    loc = os.path.join(base,
        prefix+"_"+id+""+part+".png")
    os.makedirs(base, exist_ok=True)
    print(loc)
    if part is "checkstyle":
        HTML(file).write_png(loc)
    else:
        HTML(file).write_png(loc, stylesheets=[style])

os.system("zsh -c 'cd project;git checkout -b screenshots-"+prefix+"'")
os.system("zsh -c 'cd project;git add .; git commit -am \"Added screenshots for "+prefix+"\"'")
os.system("zsh -c 'cd project;git push --set-upstream origin screenshots-"+prefix+"'")

os.system("zsh -c 'rm -rf ./project'")
