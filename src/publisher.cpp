#include <quickmsg/publisher.hpp>

namespace quickmsg {

  Publisher::Publisher(const std::string& topic)
    : topic_(topic)
  {
    // create the group node
    std::string name("P/");
    node_ = new GroupNode(name + topic);
    node_->join(topic_);
    node_->async_spin();
    node_->wait_join(topic_);
  }

  Publisher::~Publisher()
  {
    node_->leave(topic_);
    node_->stop();
    delete node_;
  }

  void 
  Publisher::publish(const std::string& msg)
  {
    node_->shout(topic_, msg); // done
  }

}
