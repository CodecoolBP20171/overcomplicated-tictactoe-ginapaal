from flask import Flask
import json
import requests


app = Flask("funfact")


@app.route("/funfact")
def funfact():
    funfact = requests.get("https://api.chucknorris.io/jokes/random").json().get("value")
    return json.dumps({"funfact": funfact})


def main():
    app.run(port=60000, debug=True)


if __name__ == '__main__':
    main()